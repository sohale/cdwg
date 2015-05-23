var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    var socket = new SockJS('/wsckendpoint');  // ---> @MessageMapping("/wsckendpoint") in the controller class
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected*: ' + frame);
        stompClient.subscribe(
            '/topic/greetings',  //the receiver point (also clarified in @SendTo)

            function(greeting){
                    //The [wrapped] object greeting is received from (generated in, returned at) the WsckEndpoint. It's a JSON object wrapped in field ".body" of greeting.
                    //The full result returned from wsckendpoint is packaged into greeting.body (collected and directed to here through /topic/greetings ))
                console.log('Going to call showGreeting. greeting='+greeting.body);
                    //not called. ... then-->... now called after fixing:  /app/hello --> /app/wsckendpoint
                    //greeting is shown as 'MESSAGE'
                showGreeting(JSON.parse(greeting.body).mytext);
            }

        );
        console.log('[Connected: done]');
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected./");
}

//Called on click of the button
function sendName() {
    var name = document.getElementById('name').value; //html field id='name'
    console.log("name will be "+name );
    //jsn_string=JSON.stringify({ 'myStompText': name }); //opposite of parse()
    jsn_string=JSON.stringify({ 'myStompText': name }); //opposite of parse()
    console.log("jsn_string = "+jsn_string );
    //jsn_string = {"myStompText":"ZOZI"} has the correct content. (a correct MyStompMessage object; an object that looks like that.)
    //But it is received as an empty obj on the receiver side. using default constructor there?
    stompClient.send("/app/wsckendpoint", {}, jsn_string); //Send that field into /app/hello ---> /app/wsckendpoint
}

function showGreeting(message) {
    console.log('***showGreeting: ' + message);
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message));
    response.appendChild(p);
}
