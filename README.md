# LinuxService

Just a quick bit of server code to test out installing it as a service on Centos.

Build the jar file from the classes under src and deploy to

/opt/JavaServer/lib

Create a directory called 

/opt/JavaServer/config

(this just holds a file with the PID in it so far).

Copy the JavaServer file to /etc/init.d and then you can:

$ service JavaServer start|stop|restart|status

Test it using:

$ curl http://localhost:8181/test
I'm alive!
