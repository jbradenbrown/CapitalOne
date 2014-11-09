require 'socket';

server = TCPServer.open 1566
clients = [];
loop {
    Thread.start server.accept do |client|
        clients << client
        while line = client.gets
            linesplit = line.split
            case linesplit[0]
                when 'v'
                    
