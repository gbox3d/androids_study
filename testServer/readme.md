## 기본 프로토콜

```txt
[header][data][tail]
```

### 해더 
```txt
0 : stx(1) , 0x02  
1 : code(1) , 예를 들어 0x05 는 ping
2 : count(2) , 통신 카운트 ,일반적으로 0
3 :
4 : id(4) 
5 :
6 :
7 :
8 : data size(4)

```

### code

0x05(ping) ->  0x01(ack)  

### 사용법

```
pm2 start npm --name "udp_babeq_server" -- run udp
pm2 start npm --name "tcp_babeq_server" -- run tcp
```


