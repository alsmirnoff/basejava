package ru.javawebinar.basejava.exception;

public class NotExistStorageException extends StorageException{
    public NotExistStorageException(String uuid) {
        super("ERROR: resume " + uuid + " not exist!", uuid);
    }
}