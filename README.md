# S8_AM_RMIWebHook

Mini project Java RMI simulating web hooks

## How to use

### Server

* Launch the server by launching the ```MainServer``` class with no arguments
* The server will register his remote object ```Server``` at the RMI URL: ```rmi://localhost/cancelarousseau``` by default using the registry default port (1099)
* A prompt will appear where you will be able to type your commands.

#### Available commands for Server

* ```send <message>``` : Sends `<message>` to all subscribers.
* ```loto``` : Sends random loto numbers to all subscribers.
* ```help``` : Shows all available commands.

### Client

* Launch the client by launching the ```MainClient``` class with no arguments.
* You'll be asked to enter the server IP (Only the IP !) in our case, it will be ```localhost```.
* Then you'll be asked to enter a nickname to be indentified by the server (a string whatever you want).
* A prompt will appear where you will be able to type your commands.

#### Available commands for Client

* ```sub``` : Subscribes to the server (If already subscribed, the server will ignore this request)
* ```unsub``` : Unsubscribes to the server (If already unsubscribed, the server will ignore this request)
* ```help``` : Shows all available commands.
* ```exit``` : Unsubscribes to the server and exit the client.