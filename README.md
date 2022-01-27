# Flow Demo

### Cold and Hot flows
Cold Flows -  Won't trigger any producer code until a terminal operator is called.
Terminal operators are suspending functions that start the collection of the flow.
For each new collector there will be a new Flow created.

Hot Flow - Collecting from the flow doesn't trigger any producer code.
A shared flow is called hot because its active instance exists independently of the presence of collectors
When a new consumer starts collecting from the flow, it receives the last state in the stream and any subsequent states.

### Flow
Cold flow
Stateless - value can't be accessed through .value
Often used in Data layers

### StateFlow
Hot flow
Requires an initial state to be passed in to the constructor
Not tied to a lifecycle, and thus does not stop collecting automatically.
A StateFlow is always active and in memory, and it becomes eligible for garbage collection only when there are no other references to it from a garbage collection root.

### SharedFlow
Hot flow
Broadcast fashion
Replay option for new consumers
Subscription count


https://flowmarbles.com/
