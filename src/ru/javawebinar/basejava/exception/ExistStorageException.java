package ru.javawebinar.basejava.exception;

public class ExistStorageException extends StorageException{
    public ExistStorageException(String uuid) {
        super("ERROR: resume " + uuid + " already exist!", uuid);
    }
}
