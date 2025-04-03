1. What is the MVP (Minimum Viable Product)?
   ✅ User requests a ride from Point A to B.
   ✅ Nearest available driver receives a notification via Kafka-based event-driven system.
   ✅ Only one driver can accept the ride (race condition handling required).
   ✅ Ride tracking (location updates) happens in real time.
   ✅ Ride completion process: Both user & driver confirm ride completion.
   ✅ Ride history: Stored for both user and driver.
   ✅ Ride cost calculation based on time, distance, and surge pricing.

2. What about the estimation of scaling?
   ✅ Initially, we will have single-instance services, but we should design them for horizontal scaling using multiple instances behind a load balancer (e.g., Nginx, API Gateway).
   ✅ Kafka-based event-driven architecture ensures that our system scales efficiently.
   ✅ Sharding & partitioning can be applied later if needed.

3. Is sharding required? Is it read-heavy, write-heavy, or both?
   ✅ The system is both read-heavy and write-heavy:
          i) Read-heavy: Fetching ride history, user profiles, driver locations.
         ii) Write-heavy: Live ride tracking, trip status updates.
   ✅ Sharding may be required for ride history, as past rides will accumulate over time.

4. Is this system high-availability (HA) or high-consistency (HC)?
   ✅ High-Availability (HA) is preferred because ride matching must happen in real time without downtime.
   ✅ Eventual Consistency is acceptable in some areas (e.g., ride history).
   ✅ Strong Consistency is needed for:
          i) Ensuring only one driver accepts a ride.
         ii) Payment transactions.

5. What about latency?
   ✅ Ultra-low latency is required for ride matching & live tracking (<100ms response time).
   ✅ Kafka event-driven model ensures low-latency push notifications.
   ✅ Redis caching for frequent reads (e.g., driver locations, active rides).

6. What database are we using? SQL or NoSQL?
   Hybrid approach:
   ✅ SQL (MySQL) for transactional data (e.g., ride bookings, payments).
   ✅ NoSQL (MongoDB/Redis) for location tracking, ride history caching.

7. Can we afford data loss?
   ✅ No, data loss is not acceptable!
   ✅ For critical data (ride transactions, payments), we use ACID-compliant SQL (MySQL).
   ✅ For real-time events (location updates), temporary inconsistencies are acceptable, but eventual consistency must be ensured via Kafka.

8. How are we planning API design?
   ✅ RESTful APIs with proper versioning (/api/v1/rides, /api/v1/payments).
   ✅ Async communication between services using Kafka.
   ✅ Rate limiting & authentication via API Gateway.

9. What is the system diagram?

           [ User App ]           [ Driver App ]
                |                        |
           [ API Gateway ]  <------->  [ Load Balancer ]
                |                        |
   ---------------------------------------------
    |             |                |           |
    [ Ride Service ]  [ Notification Service ] [ Payment Service ]
    |             |                |           |
    [ MySQL ]    [ Redis ]        [ Kafka ]   [ MySQL ]
    |                      |
    [ MongoDB ]            [ Kafka Topics ]


10. How will data flow look?
    ✅ Ride Booking Flow
    ✅ User requests a ride → Ride service saves it in MySQL.
    ✅ Ride Service publishes an event to Kafka (ride_requested).
    ✅ Notification Service listens to Kafka and notifies the nearest driver.
    ✅ Driver accepts the ride → Kafka updates Ride Service.
    ✅ Location tracking starts → Ride Service stores updates in MongoDB.
    ✅ User completes ride → Payment Service calculates fare & charges user.
    ✅ Ride is saved in history (MySQL for structured data, MongoDB for fast access).

