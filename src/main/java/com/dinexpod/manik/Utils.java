package com.dinexpod.manik;

public class Utils {

    public static int getTransHour(Integer hour, Integer minute) {
        switch (hour + minute) {
            case 10:
                return 0;
            case 40:
                return 1;
            case 11:
                return 2;
            case 41:
                return 3;
            case 12:
                return 4;
            case 42:
                return 5;
            case 13:
                return 6;
            case 43:
                return 7;
            case 14:
                return 8;
            case 44:
                return 9;
            case 15:
                return 10;
            case 45:
                return 11;
            case 16:
                return 12;
            case 46:
                return 13;
            case 17:
                return 14;
            case 47:
                return 15;
            case 18:
                return 16;
            case 48:
                return 17;
            case 19:
                return 18;
            case 49:
                return 19;
            case 20:
                return 20;
            case 50:
                return 21;
        }

        return 100;
    }

    public static int getServiceTime(String mainService, String dopService) {
        double mainServiceTime;
        double dopServiceTime = 0;

        switch (mainService) {
            case "no":
                mainServiceTime = 0;
                break;
            case "snyatie":
                mainServiceTime = 30;
                break;
            case "snyatie_gelya":
                mainServiceTime = 40;
                break;
            case "classMan":
            case "combMan":
            case "aparMan":
            case "manMan":
            case "snyatie_classMan":
            case "snyatie_combMan":
            case "pokr_gelLak":
            case "manPed":
                mainServiceTime = 60;
                break;
            case "snyatie_aparMan":
                mainServiceTime = 70;
                break;
            case "classMan_pokr":
            case "combMan_pokr":
            case "aparMan_pokr":
                mainServiceTime = 90;
                break;
            case "snyatie_classMan_pokr":
            case "snyatie_combMan_pokr":
            case "snyatie_aparMan_pokr":
                mainServiceTime = 120;
                break;
            case "narashch":
                mainServiceTime = 210;
                break;
            case "korrekts_gel":
                mainServiceTime = 170;
                break;
            default:
                mainServiceTime = 1000;
                break;
        }

        if (dopService.contains("pokr_usualLak")) {
            dopServiceTime += 15;
        }

        if (dopService.contains("dezVsehNogt")) {
            dopServiceTime += 30;
        }

        if (dopService.contains("grad")) {
            dopServiceTime += 60;
        }

        if (dopService.contains("ukrepNogtey")) {
            dopServiceTime += 15;
        }

        if (dopService.contains("remOneNail")) {
            dopServiceTime += 5;
        }

        if (dopService.contains("remTwoNails")) {
            dopServiceTime += 10;
        }

        if (dopService.contains("remThreeNails")) {
            dopServiceTime += 15;
        }

        double result = (dopServiceTime + mainServiceTime) / 30;

        return (int) Math.ceil(result);
    }
}
