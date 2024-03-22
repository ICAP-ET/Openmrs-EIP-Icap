package org.openmrs.eip.example;

public class Event {
    private String tableName;
    private int primaryKeyId;
    private String identifier;
    private char operation;
    private boolean snapshot;

    // Constructor, getters, and setters

    public Event(String tableName, int primaryKeyId, String identifier, char operation, boolean snapshot) {
        this.tableName = tableName;
        this.primaryKeyId = primaryKeyId;
        this.identifier = identifier;
        this.operation = operation;
        this.snapshot = snapshot;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(int primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public boolean isSnapshot() {
        return snapshot;
    }

    public void setSnapshot(boolean snapshot) {
        this.snapshot = snapshot;
    }
}
