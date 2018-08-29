package one.wangwei.blockchain.network;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * P2P网络中的节点信息
 *
 * @author wangwei
 * @date 2018/08/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeerInfo {

    /**
     * peer在p2p网络的唯一标示
     */
    private String id;
    /**
     * IP 地址
     */
    private String host;
    /**
     * TCP 端口
     */
    private int port;

    public PeerInfo(String host, int port) {
        this(host + ":" + port, host, port);
    }

    public PeerInfo(int port) {
        this(null, port);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeerInfo peerInfo = (PeerInfo) o;
        return port == peerInfo.port &&
                Objects.equals(id, peerInfo.id) &&
                Objects.equals(host, peerInfo.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, host, port);
    }
}
