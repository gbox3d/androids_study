const dgram = require("dgram");
var port = 50020;

const server = dgram.createSocket("udp4");
const networkInterfaces = require('os').networkInterfaces

//bis 형식 날짜,시간 숫자 구하기
function getBisDateNumber(d) {
    return d.getFullYear() * 10000 + (d.getMonth() + 1) * 100 + d.getDate()

}

function getBisTimeNumber(d) {
    return d.getHours() * 10000 + d.getMinutes() * 100 + d.getSeconds()

}

function getLocalIp() {
    let localIp = Object.entries(networkInterfaces())
        .map(o => [o[0], o[1].filter(q => q.family === 'IPv4' && !q.internal).map(r => r && r.address)]).filter(([a, b]) => b.length > 0)
        .map(([a, b]) => b[0])[0];

    return localIp;
}

var deviceList = {}

server.on("message", function (msg, rinfo) {

    console.log(rinfo);
    console.log(msg);

    let _offset = 0;
    let _stx = msg.readUInt8(_offset++)
    let _code = msg.readUInt8(_offset++)
    let _sr_cnt = msg.readUInt16LE(_offset)
    _offset += 2
    let _id = msg.readUInt32LE(_offset)
    _offset += 4
    let _data_size = msg.readUInt32LE(_offset)
    _offset += 4

    console.log(`code : ${_code}, id : ${_id} ,sr_cnt : ${_sr_cnt} ,data size : ${_data_size}`)

    deviceList[_id] = {
        rinfo : rinfo,
        at : (new Date()).getTime()
    }
    

    let resBuf = new Buffer.alloc(128)
    _offset = 0
    switch (_code) {
        case 0x05: //ping
            {
                //응답 만들어 보내기 
                resBuf.writeUInt8(0x02, _offset++) // stx
                resBuf.writeUInt8(0x01, _offset++) //op code ack ,0x01
                resBuf.writeUInt16LE(_sr_cnt + 1, _offset) //sr_cnt
                _offset += 2
                resBuf.writeUInt32LE(_id, _offset)
                _offset += 4
                resBuf.writeUInt32LE(12, _offset) //data size
                _offset += 4

                //body
                let _date = new Date()
                resBuf.writeUInt32LE(getBisDateNumber(_date), _offset)
                _offset += 4
                resBuf.writeUInt32LE(getBisTimeNumber(_date), _offset)
                _offset += 4
                resBuf.writeUInt8(_code, _offset++) //대상 opcode
                _offset += 3 //예약 영역
                
                resBuf.writeUInt8(0, _offset++) //check sum
                resBuf.writeUInt8(0x03, _offset++) //etx
            }
            break;
        default:
            {
                resBuf.writeUInt8(0x02, _offset++) // stx
                resBuf.writeUInt8(0x10, _offset++) //op code : no command 0x10
                resBuf.writeUInt16LE(_sr_cnt + 1, _offset) //sr_cnt
                _offset += 2
                resBuf.writeUInt32LE(_id, _offset)
                _offset += 4
                resBuf.writeUInt32LE(0, _offset) //data size
                _offset += 4
                resBuf.writeUInt8(0, _offset++) //check sum
                resBuf.writeUInt8(0x03, _offset++) //etx


            }
            break;
    }

    server.send(
        resBuf, 0, _offset,
        rinfo.port, rinfo.address); // added missing bracket
});

function startup()
{
    let port = 50020
    if (process.argv.length > 2) {
        port = parseInt(process.argv[2])
    }
    else {
        console.log('default port bind')
    }

    server.bind(port);
    
    console.log(`udp server bind at ${getLocalIp()} : ${port}`)
    
};

startup()