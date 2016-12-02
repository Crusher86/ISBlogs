package ru.innopolis.isblogs.utils;

/**
 * Created by Crusher on 01.12.2016.
 */
public class ApplicationException extends Exception{

    private static final String NOT_CONNETCTION = "Could not connect to database!";

        public ApplicationException(){

        super(NOT_CONNETCTION);

    }
}
