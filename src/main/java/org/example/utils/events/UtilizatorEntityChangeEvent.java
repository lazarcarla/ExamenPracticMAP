package org.example.utils.events;


import org.example.domain.Tablou;

public class UtilizatorEntityChangeEvent implements Event {
    private ChangeEventType type;
    private Tablou data, oldData;

    public UtilizatorEntityChangeEvent(ChangeEventType type, Tablou data) {
        this.type = type;
        this.data = data;
    }
    public UtilizatorEntityChangeEvent(ChangeEventType type, Tablou data, Tablou oldData) {
        this.type = type;
        this.data = data;
        this.oldData=oldData;
    }

    public ChangeEventType getType() {
        return type;
    }

    public Tablou getData() {
        return data;
    }

    public Tablou getOldData() {
        return oldData;
    }
}