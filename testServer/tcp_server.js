const net = require('net');
const { off } = require('process');

var theApp = {
    port : 50021
}

if (process.argv.length > 2) {
    theApp.port = parseInt(process.argv[2])
}
else {
    console.log('default port bind')
}

net.createServer(function (socket) {

    // We have a connection - a socket object is assigned to the connection automatically
    console.log('CONNECTED: ' + socket.remoteAddress + ':' + socket.remotePort);

    // Add a 'data' event handler to this instance of socket
    socket.on('data', async function (msg) {

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

        let message = new Buffer.alloc(128);
        let offset = 0;

        if (_code == 0x05) { //ping

            message.writeUInt8(0x02, offset++) //STX
            message.writeUInt8(0x1, offset++) //OPCODE ,ping
            message.writeUInt16LE(0, offset) //sr_cnt
            offset += 2
            message.writeUInt32LE(_id, offset) //id
            offset += 4;
            message.writeUInt32LE(0, offset) //data size
            offset += 4;

            message.writeUInt8(0x00, offset++) //checksum
            message.writeUInt8(0x03, offset++) //ETX

        }
        else {
            message.writeUInt8(0x02, offset++) //STX
            message.writeUInt8(0x10, offset++) //OPCODE  , nocode
            message.writeUInt16LE(0, offset) //sr_cnt
            offset += 2
            message.writeUInt32LE(_id, offset) //id
            offset += 4;
            message.writeUInt32LE(0, offset) //data size
            offset += 4;

            message.writeUInt8(0x00, offset++) //checksum
            message.writeUInt8(0x03, offset++) //ETX

        }

        //동기화 
        await new Promise((resolve,reject)=> {
            socket.write(message.slice(0, offset), () => {
                console.log(`send pkt ${offset}`)
                resolve()
            });
        }) 

        //1초 대기 
        await new Promise((resolve,reject)=> {
            setTimeout(()=> {
                resolve()
            },1000)
        }) 

        {
            offset = 0;
            message.writeUInt8(0x02, offset++) //STX
            message.writeUInt8(0xff, offset++) //OPCODE  , nocode
            message.writeUInt8(0x00, offset++) //checksum
            message.writeUInt8(0x03, offset++) //ETX
        }
        //동기화 
        await new Promise((resolve,reject)=> {
            socket.write(message.slice(0, offset), () => {
                console.log(`send pkt ${offset}`)
                resolve()
            });
        }) 


        //3초 대기 
        await new Promise((resolve,reject)=> {
            setTimeout(()=> {
                resolve()
            },3000)
        }) 

        //접속 종료 
        socket.destroy()
        



        // console.log('DATA ' + socket.remoteAddress + ': ' + data);
        // console.log(data);
        // console.log(`STX : ${data.readUInt8(0)}`)
        // console.log(`opcode : ${data.readUInt8(1)}`)
        // console.log(`sr_count : ${data.readUInt8(2)}`)
        // console.log(`obe_id : ${data.readUInt32LE(4)}`)
        // console.log(`veh_id : ${data.readUInt32LE(8)}`)
        // // Write the data back to the socket, the client will receive it as data from the server
        // socket.write('You said "' + data + '"' + "\n");

    });

    // Add a 'close' event handler to this instance of socket
    socket.on('close', function (data) {
        console.log('CLOSED: ');
        //console.log(JSON.stringify(socket.getConnection()));
    });

}).listen(theApp.port);

//console.log('Server listening on ' + HOST +':'+ PORT);
console.log(`Server listening on : ${theApp.port}`);
