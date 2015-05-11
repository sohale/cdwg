Requirements
============

Low latency
-----------
The message (event) of a _client_'s *choice* should be received by his adjacent-peer (another _client_) with very low latency using common internet connections.

Design Decisions
================
Use both client-client and client-server communication.

1. Use a slow connection between the client (app) and server. It will be using REST and will be queued.
..* Offline is not necessary really.

2. Use a fast low latency between clients. WebSockets.

Q:
How the consistency is checked. 
Which ones are bidirectional?


Appendices
==========

SCHEDULE B
----------
DEVELOPMENT DELIVERABLES AND FEE SCHEDULE
ALL TO BE PAID WITHIN 30 DAYS OF SIGN OFF

Milestones
Deliverable:
Target Date:
Payment:
MS1: Project Start
Contract signed, design documents delivered to Wide IO Consulting Ltd, scope and requirements of project defined.
Start date of the project
£5,000
MS2: Web Prototype
First prototype is implemented as a simple website with main communication functionalities in their basic form: Response Collection, Web-to-Backend Communication, User-to-User Communication. Experiment parameters and the graph are set by the Developer
4 weeks
£4,500
MS3: web App Alpha Standard
First working web App with an intermediate interface, fully functional low-latency and reliable communication between users (communication latency is measured). One Stimulus Presentation. Synchrony of stimulus presentation. Experimenter’s Control panel is minimal (text).
8 weeks
£4,500
MS4: web App Beta Standard
Fully functional web App. User registration and authentication. Test run with invited users.
12 Weeks
£4,500
MS5: Completed
Production quality web App. The interface design is complete. Quality control and tests passes. Troubleshooting.
16 weeks
£5,000
MS6: Web App Gold Master Standard
The web App is ready for conducting experiments with public users.
18 weeks
£2,500


|   | Milestone     |Target Date     |        |                                                                         Deliverable: |
|--:|--------------:|---------------:|-------:|-------------------------------------------------------------------------------------:|
|MS1| Project Start | Start date     |  5,000 | Contract signed, design documents delivered to Wide IO Consulting Ltd, scope and requirements of project defined.|
|MS2| Web Prototype | 4 weeks        |  4,500 | First prototype is implemented as a simple website with main communication functionalities in their basic form: Response Collection, Web-to-Backend Communication, User-to-User Communication. Experiment parameters and the graph are set by the Developer|
|MS3| web App Alpha | 8 weeks        |  4,500 | First working web App with an intermediate interface, fully functional low-latency and reliable communication between users (communication latency is measured). One Stimulus Presentation. Synchrony of stimulus presentation. Experimenter’s Control panel is minimal (text).|
|MS4| web App Beta  | 12 Weeks       |  4,500 | Fully functional web App. User registration and authentication. Test run with invited users.|
|MS5| Completed     | 16 weeks       |  5,000 | Production quality web App. The interface design is complete. Quality control and tests passes. Troubleshooting.|
|MS6| Web App Gold  | 18 weeks       |  2,500 | The web App is ready for conducting experiments with public users. |


The prices above are stated in Pounds Sterling [GBP].
Prices do not include Value Added Tax [VAT] which is payable at the legally prevailing rate.

The definitions of standards at each phase are as follows:
* Alpha Standard: Software contains the core functionality of one stimulus and connectivity with a predefined network of users. Game can be played in a test setting. Game may contain placeholder or incomplete assets in some places.
* Beta Standard: Software contains all components necessary to meet the specifications documentation referenced above, game can be played by invited users/testers. Game may contain placeholder or incomplete assets in some places.
* Gold Master Standard: All placeholder assets have been replaced with the final shippable versions. QA pass has been completed and all identified bugs have been either fixed in the software, or Client and Developer are in agreement that the issue can be overlooked. This version should be ready for public release.




References
==========
* [Java Modeling Language](http://en.wikipedia.org/wiki/Java_Modeling_Language)
