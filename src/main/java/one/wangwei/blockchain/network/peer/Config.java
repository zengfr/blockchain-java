package one.wangwei.blockchain.network.peer;

import lombok.Data;

@Data
public class Config {

    public static final int DEFAULT_MIN_NUMBER_OF_ACTIVE_CONNECTIONS = 5;

    public static final int DEFAULT_MAX_READ_IDLE_SECONDS = 120;

    public static final int DEFAULT_KEEP_ALIVE_SECONDS = 15;

    public static final int DEFAULT_PING_TIMEOUT_SECONDS = 5;

    public static final int DEFAULT_AUTO_DISCOVERY_PING_FREQUENCY = 10;

    public static final int DEFAULT_PING_TTL = 7;

    public static final int DEFAULT_LEADER_ELECTION_TIMEOUT_SECONDS = 5;

    public static final int DEFAULT_LEADER_REJECTION_TIMEOUT_SECONDS = 10;

    /**
     * Name of the peer. It must be unique across the p2p network
     */
    private String peerName;

    /**
     * When a peer has less number of connections than min number of active connections,
     * it pings other peers periodically and try to connect to new peers
     */
    private int minNumberOfActiveConnections = DEFAULT_MIN_NUMBER_OF_ACTIVE_CONNECTIONS;

    /**
     * When a peer does not send any message for the specified amount of seconds, it will be disconnected
     */
    private int maxReadIdleSeconds = DEFAULT_MAX_READ_IDLE_SECONDS;

    /**
     * Amount of time that a peer will send periodic keep-alive messages to its neighbours to indicate that it is alive
     */
    private int keepAlivePeriodSeconds = DEFAULT_KEEP_ALIVE_SECONDS;

    /**
     * Amount of seconds that pong responses will be waited for an initiated ping
     */
    private int pingTimeoutSeconds = DEFAULT_PING_TIMEOUT_SECONDS;

    /**
     * Amount of neighbour jumps an initial ping message will do
     */
    private int pingTTL = DEFAULT_PING_TTL;

    /**
     * When a peer automatically sends keep-alive messages periodically, it makes the
     * {@code autoDiscoveryPingFrequency}th a full ping
     */
    private int autoDiscoveryPingFrequency = DEFAULT_AUTO_DISCOVERY_PING_FREQUENCY;

    /**
     * When a peer starts an election, it waits until leader election timeout duration passes.
     * If there is no rejection message is received until timeout, peer announces itself as leader.
     */
    private int leaderElectionTimeoutSeconds = DEFAULT_LEADER_ELECTION_TIMEOUT_SECONDS;

    /**
     * When a peer receives a rejection, it cancels its own election and waits until leader rejection
     * timeout duration passes. If there is no announced leader at the end of the duration, peer
     * starts a new election.
     */
    private int leaderRejectionTimeoutSeconds = DEFAULT_LEADER_REJECTION_TIMEOUT_SECONDS;


    @Override
    public String toString() {
        return "Config{" +
                "peerName='" + peerName + '\'' +
                ", minNumberOfActiveConnections=" + minNumberOfActiveConnections +
                ", maxReadIdleSeconds=" + maxReadIdleSeconds +
                ", keepAlivePeriodSeconds=" + keepAlivePeriodSeconds +
                ", pingTimeoutSeconds=" + pingTimeoutSeconds +
                ", pingTTL=" + pingTTL +
                ", autoDiscoveryPingFrequency=" + autoDiscoveryPingFrequency +
                ", leaderElectionTimeoutSeconds=" + leaderElectionTimeoutSeconds +
                ", leaderRejectionTimeoutSeconds=" + leaderRejectionTimeoutSeconds +
                '}';
    }
}
