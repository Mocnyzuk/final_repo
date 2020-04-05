package com.example.demo.controller;

public class BadEmailException extends Exception {
    public BadEmailException(String badEmail) {
        super(badEmail);
    }
}