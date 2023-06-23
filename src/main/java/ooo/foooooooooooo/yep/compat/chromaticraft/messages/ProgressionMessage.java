package ooo.foooooooooooo.yep.compat.chromaticraft.messages;

import ooo.foooooooooooo.yep.messages.IYepMessage;
import ooo.foooooooooooo.yep.messages.MessageType;

public class ProgressionMessage implements IYepMessage {
    private final String title;

    public ProgressionMessage(String title) {
        this.title = title;
    }

    @Override
    public MessageType getType() {
        return MessageType.CC_PROGRESSION;
    }

    @Override
    public String toString() {
        return title;
    }
}
