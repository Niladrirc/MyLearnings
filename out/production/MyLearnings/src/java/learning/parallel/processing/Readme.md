# Stream API: Parallel Processing

Parallel streams in Java utilize the concept of multi-threading to process data concurrently and potentially improve the overall performance.

The parallel stream framework automatically divides the workload into smaller tasks assign them to multiple threads for parallel execution.

## Sequential Streams

- Process elements in a stream in a serial manner, one after another.
- Operations are executed ina single thread, following the order of stream.
- Suitable for small to medium-sized datasets or operations where order of execution is important.
- Can be created by default when working with streams.

## Parallel Streams

- Process elements concurrently, utilizing multiple threads.
- Operations are divided into multiple tasks that can be executed simultaneously on different threads.
- Suitable for large data-sets or operations that can be performed independently.
- Created by converting a sequential stream to a parallel stream using the `parallel()` method.

## How parallel streams work?
- Data partitioning
- Task Distribution
- Concurrent Processing
- Result Aggregation

    ### Data Partitioning
    Suppose there is an underlying framework, responsible for creating multiple threads, managing it and assigning data to process it.
When we create parallel streams, the underlying framework divides the data into smaller partitions and those partitions are assigned to the threads.

    ### Task Distribution
    The framework distributes all data partitions to the available threads in the thread-pool.
It creates a thread pool and uses those threads to assign these partitioned tasks.

    ### Concurrent Processing
    The tasks that are assigned partitioned data will execute concurrently.

    ### Result Aggregation
    Once processing is completed, the result from all the concurrent task/thread is merged to produce the final result.
