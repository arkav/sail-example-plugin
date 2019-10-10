import dev.arkav.openoryx.net.packets.PacketType;
import dev.arkav.openoryx.net.packets.s2c.MapInfoPacket;
import dev.arkav.openoryx.net.packets.s2c.TextPacket;
import dev.arkav.sail.api.Plugin;
import dev.arkav.sail.api.SailPlugin;
import dev.arkav.sail.impl.SailProxy;

@SailPlugin
public class ExamplePlugin implements Plugin {
    @Override
    public void initalize(SailProxy sailProxy) {
        sailProxy.getListenerStore().hook(PacketType.MAPINFO, (MapInfoPacket p) -> {
            TextPacket tp = TextPacket.createDefault();
            tp.text = "Hello Sail";
            tp.cleanText = "Hello Sail";
            sailProxy.getClient().send(tp);
        });
    }
}
