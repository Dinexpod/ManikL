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


    public static String getEndMeetTime(int endTimeIndex) {
        switch (endTimeIndex) {
            case 0:
                return "10:30";
            case 1:
                return "11:00";
            case 2:
                return "11:30";
            case 3:
                return "12:00";
            case 4:
                return "12:30";
            case 5:
                return "13:00";
            case 6:
                return "13:30";
            case 7:
                return "14:00";
            case 8:
                return "14:30";
            case 9:
                return "15:00";
            case 10:
                return "15:30";
            case 11:
                return "16:00";
            case 12:
                return "16:30";
            case 13:
                return "17:00";
            case 14:
                return "17:30";
            case 15:
                return "18:00";
            case 16:
                return "18:30";
            case 17:
                return "19:00";
            case 18:
                return "19:30";
            case 19:
                return "20:00";
            case 20:
                return "20:30";
            case 21:
                return "21:00";
        }

        return "0";
    }

    public static String dayOfWeekFromEngToRus(String dayOfWeek) {
        switch (dayOfWeek) {
            case "MONDAY":
                return "понедельник";
            case "TUESDAY":
                return "вторник";
            case "WEDNESDAY":
                return "среда";
            case "THURSDAY":
                return "четверг";
            case "FRIDAY":
                return "пятница";
            case "SATURDAY":
                return "суббота";
            case "SUNDAY":
                return "воскресенье";
            default:
                return "-";
        }
    }

    public static String parseServicesList(String mainService, String dopService) {
        StringBuilder servicesList = new StringBuilder();

        switch (mainService) {
            case "no":
                servicesList.append(" ");
                break;
            case "snyatie":
                servicesList.append("снятие");
                break;
            case "snyatie_gelya":
                servicesList.append("снятие геля");
                break;
            case "classMan":
                servicesList.append("классический маникюр");
                break;
            case "combMan":
                servicesList.append("комбинированный маникюр");
                break;
            case "aparMan":
                servicesList.append("аппаратный маникюр");
                break;
            case "manMan":
                servicesList.append("мужской маникюр");
                break;
            case "classMan_pokr":
                servicesList.append("классический маникюр + покрытие");
                break;
            case "combMan_pokr":
                servicesList.append("комбинированный маникюр + покрытие");
                break;
            case "aparMan_pokr":
                servicesList.append("аппаратный маникюр + покрытие");
                break;
            case "snyatie_classMan":
                servicesList.append("снятие + классический маникюр");
                break;
            case "snyatie_combMan":
                servicesList.append("снятие + комбинированный маникюр");
                break;
            case "snyatie_aparMan":
                servicesList.append("снятие + аппаратный маникюр");
                break;
            case "snyatie_classMan_pokr":
                servicesList.append("снятие + классический маникюр + покрытие");
                break;
            case "snyatie_combMan_pokr":
                servicesList.append("снятие + комбинированный маникюр + покрытие");
                break;
            case "snyatie_aparMan_pokr":
                servicesList.append("снятие + аппаратный маникюр + покрытие");
                break;
            case "pokr_gelLak":
                servicesList.append("покрытие гель-лаком");
                break;
            case "narashch":
                servicesList.append("наращивание ногтей");
                break;
            case "korrekts_gel":
                servicesList.append("коррекция геля");
                break;
            case "manPed":
                servicesList.append("мужской педикюр");
                break;
            default:
                servicesList.append("ОШИБКА");
                break;
        }

        if (dopService.contains("pokr_usualLak")) {
            servicesList.append(" + покрытие обычны/лечебным лаком");
        }

        if (dopService.contains("dezVsehNogt")) {
            servicesList.append(" + дизайн всех ногтей");
        }

        if (dopService.contains("grad")) {
            servicesList.append(" + градиент");
        }

        if (dopService.contains("ukrepNogtey")) {
            servicesList.append(" + укрепление ногтей");
        }

        if (dopService.contains("remOneNail")) {
            servicesList.append(" + ремонт 1 ногтя");
        }

        if (dopService.contains("remTwoNails")) {
            servicesList.append(" + ремонт 2 ногтей");
        }

        if (dopService.contains("remThreeNails")) {
            servicesList.append(" + ремонт 3 ногтей");
        }

        return servicesList.toString();
    }
}
