HW-05: Airport Management Application with Observer Design Pattern

This application demonstrates an Airport Management Application with Observer Design Pattern. The application allows flight display boards and websites to receive flight departure and arrival events.


1. Observable Classes:
	- DepartureObservable: Handles DepartureEvent updates.
		a) Manages a list of DepartureObservers.
		b) Notifies observers when a DepartureEvent occurs.
	- ArrivalObservable: Handles ArrivalEvent updates.
		a) Manages a list of ArrivalObservers.
		b) Notifies observers when an ArrivalEvent occurs.

2. Observer Interfaces:
	- DepartureObserver: with updateDeparture().
	- ArrivalObserver: with updateArrival().

3. Observer Implementations:
	- BoardObserver: Observes both Departure and Arrival events for display on the Airport Display Board.
	- WebsiteObserver: Observes both Departure and Arrival events for updates on the Airport Website.

4. Events:
	- DepartureEvent: Represents the departure event.
	- ArrivalEvent: Represents an arrival event.

5. Implemented and tested with JUnit for various DepartureEvents and ArrivalEvents.