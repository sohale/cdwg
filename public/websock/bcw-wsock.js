
        var    CONTROLLER_EP_SUFFIX ="/broadcast-change-ws-endpoint"; // "/wsckendpoint"
        var    APP_WEBSOCK_PREFIX = "/wsapp"; //"/app";
        var    APP_WEBSOCK_FULL = APP_WEBSOCK_PREFIX+ CONTROLLER_EP_SUFFIX; // "/app/wsckendpoint"
        var    STOMPSUBSCR_SUFFIX = "/choice-update-broadcaster";  // "/greetings"
        var    STOMPSUBSCR_PREFIX = "/bc-game-1";  // "/topic"
        var    STOMPSUBSCR_FULL = STOMPSUBSCR_PREFIX+STOMPSUBSCR_SUFFIX; // "/bc-game-1/choice-update-broadcaster" //"/topic/greetings"
            //RECEIVER_POINT = STOMPSUBSCR_FULL
            //RECEIVER_POINT='/topic/greetings',  //the receiver point (also clarified in @SendTo)

/*
    var CONTROLLER_EP_SUFFIX = "/wsckendpoint";
    var APP_WEBSOCK_PREFIX = "/app";
    var APP_WEBSOCK_FULL = APP_WEBSOCK_PREFIX+ CONTROLLER_EP_SUFFIX;
    var STOMPSUBSCR_SUFFIX = "/greetings";
    var STOMPSUBSCR_PREFIX = "/topic";
    var STOMPSUBSCR_FULL = STOMPSUBSCR_PREFIX+STOMPSUBSCR_SUFFIX;
*/
        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            console.log('11');
            console.log('11 : '+CONTROLLER_EP_SUFFIX);
            var socket = new SockJS(CONTROLLER_EP_SUFFIX);
            //var socket = new SockJS(APP_WEBSOCK_FULL); //incorrect (why?) ---> can lead to inconsistenct when SockJS switchws between websockets and http.

            console.log('22');
            stompClient = Stomp.over(socket);
            console.log('33');
            stompClient.connect({}, function(frame) {
                console.log('44');
                setConnected(true);
                console.log('Connected*: ' + frame);
                stompClient.subscribe(
                    STOMPSUBSCR_FULL,

                    function(event_obj){
                            //event_obj = a MESSAGE = {event,body}
                            //where body is [a raw string json format of] BcwChangeMessageJson
                            //(taken from controller, through STOMPSUBSCR_FULL=RECEIVER_POINT )
                            //it is json obj as opposed to a stomp obj! (see the BcwWebsockEndpoint )
                        console.log('Going to call reflectChanges(). raw json = event_obj.body ='+event_obj.body);
                        change_obj = JSON.parse(event_obj.body); //change_obj = a live object
                        reflectChanges(change_obj); //change_obj has fields
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

        //Called on click of the button. Packages a Stomp object. Uses json for intermediate operations.
        function sendChoice() {
            var uid = document.getElementById('uid').value; //html field id='name'
            var choice = document.getElementById('hischoice').value;
            var old_choice = document.getElementById('oldchoice').value; //get last choice from what is shows on screen.
            jsn_string=JSON.stringify({ 'uid': uid, 'new_choice':choice,  'old_choice':old_choice  }); //missing field old_choice
            //stringify() = opposite of parse()
            console.log("jsn_string = "+jsn_string );
            //jsn_string = a json string representation of a correct MyStompMessage object. An automatic constructor of the MessageStomp is called on this.
            console.log("send "+APP_WEBSOCK_FULL);
            stompClient.send(APP_WEBSOCK_FULL, {}, jsn_string); //Send as a string.
        }

        function reflectChanges(change_obj_json) {
            //technically, change_obj_json is not a json because it's not a string, but an object with fields. But it is parsed from a json object originated from a EndPoint controller.
            console.log('reflectChanges: ' + change_obj_json);
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            //p.appendChild(document.createTextNode(change_obj_json));
            p.appendChild(document.createTextNode("user "+change_obj_json.uid + " chose "+change_obj_json.new_choice +" (formerly "+change_obj_json.old_choice+")" ));
            //todo: change field names
            response.appendChild(p);
        }
