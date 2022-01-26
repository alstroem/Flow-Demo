# Flow Demo

### Cold and Hot flows
Cold Flows -  Won't trigger any producer code until a terminal operator is called.
Terminal operators are suspending functions that start the collection of the flow.
For each new collector there will be a new Flow created.

Hot Flow - Collecting from the flow doesn't trigger any producer code.
A StateFlow is always active and in memory, and it becomes eligible for garbage collection only when there are no other references to it from a garbage collection root.
When a new consumer starts collecting from the flow, it receives the last state in the stream and any subsequent states.

### Flow
Cold flow
Often used in Data layers
Value can't be accessed through .value

### StateFlow
Hot flow
Requires an initial state to be passed in to the constructor
Not tied to a lifecycle, and thus does not stop collecting automatically

### SharedFlow
Hot flow

