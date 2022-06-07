package com.paris.view;

import com.paris.controller.PersonController;

public class Main {
    public static void main(String[] args) {
        PersonController personController = new PersonController();
        personController.save("0024562900", "Shirin", "Jalilvand", 24);
        personController.save("0014371715", "Milad", "Tehrani", 300);

    }
}
