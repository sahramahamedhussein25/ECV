import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
public class EVC_PLUS_PROJECT {
    @SuppressWarnings("MethodMayBeTooComplex")
    public static void main(String[] args) {
        String accountNumber;
        ArrayList<String> last3Actions = new ArrayList<>();
        String lastTransaction = "Wax lacag ah lama dirin wali.";

         int main_pin = 1213;
         int choice;
        int subChoice;
        double haraagaagu = 1000.0;
        double salaamaBalance = 200.0;
        String language ;
        double billAmount = 90.0;
        boolean billPaid = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Fadlan geli code-kaaga: ");
        String code = input.nextLine();
        if (code.equals("*770#")) {
            System.out.print("Fadlan geli PIN-kaaga: ");
            int pinx = input.nextInt();
            if (pinx== main_pin) {
                do {
                    System.out.println("\nEVCPLUS");
                    System.out.println("1. Itusi haraagaagu");
                    System.out.println("2. Kaarka hadalka");
                    System.out.println("3. Bixi biil");
                    System.out.println("4. U wareeji EVCPlus");
                    System.out.println("5. warbixin kooban");
                    System.out.println("6. Salaama bank");
                    System.out.println("7. marreynta");
                    System.out.println("8. bill_payment");
                    System.out.println("9. exit");
                    System.out.print("Dooro mid (1 ama 9): ");
                    choice = input.nextInt();

                    //waa original haragaga
                    if (choice == 1) {
                        System.out.println("Haraagaagu waa: $" + haraagaagu);

                        //waa kaarka hdalka iyo intu ukla baxo wana 1-5
                    } else if (choice == 2) {
                        do {
                            System.out.println("\nKaarka hadalka");
                            System.out.println("1. Ku shubo airtime (naftaada)");
                            System.out.println("2. Ugu shub qof AIRTIME");
                            System.out.println("3. IMF packages ");
                            System.out.println("4. Ku shubo internet ");
                            System.out.println("5. Ugu shub qof kale ");
                            System.out.println("6. Exit");
                            System.out.print("Dooro mid: ");
                            subChoice = input.nextInt();
                            input.nextLine();
                            if (subChoice == 1) {
                                System.out.print("Lacagta aad rabto inaad isugu shubto: ");
                                double lacag = input.nextDouble();
                                if (lacag <= haraagaagu) {
                                    System.out.print("Ma hubtaa inaad $" + lacag + " isugu shubto? (1=Haa, 2=Maya): ");
                                    int confirm = input.nextInt();
                                    if (confirm == 1) {
                                        haraagaagu -= lacag;
                                        System.out.println("Lacagta waa la shubay. Haraagaaga cusub: $" + haraagaagu);
                                    } else {
                                        System.out.println("Howsha waa la joojiyay.");
                                    }
                                } else {
                                    System.out.println("Lacagta aad rabto waa ka badan tahay haraagaaga.");
                                }
                            } else if (subChoice == 2) {
                                System.out.print("Geli lambarka aad rabto in aad ugu shubto : ");
                                String number = input.nextLine();
                                if (number.length() != 9) {
                                    System.out.println("Lambarku waa inuu noqda 9 digit.");
                                    continue;
                                }
                                if (!number.startsWith("61")) {
                                    System.out.println("Lambarku waa inuu bilaabmaa '61'.");
                                    continue;
                                }
                                if (number.equals("613396424")) {
                                    System.out.println("Lambarka aad dirayso iyo kanaga isku mid ma noqon karaan.");
                                    continue;
                                }
                                System.out.print("Geli lacagta aad rabto in aad dirto: ");
                                double amount = input.nextDouble();
                                if (amount > haraagaagu) {
                                    System.out.println("Haraagaagu kuguma filna. Waxaad haysataa: $" + haraagaagu);
                                    continue;
                                }
                                System.out.print("Ma hubtaa in aad dirto $" + amount + " numberkan " + number + "? (1=Haa, 2=Maya): ");
                                int confirm = input.nextInt();
                                if (confirm == 1) {
                                    haraagaagu -= amount;
                                    System.out.println("Lacagta waa la diray. Haraagaaga cusub: $" + haraagaagu);
                                } else {
                                    System.out.println("Howsha waa la joojiyay.");
                                }
                                input.nextLine();
                            } else if (subChoice == 3) {
                                System.out.println("1. $5 = 10GB (1 usbuuc)");
                                System.out.println("2. $10 = 25GB (2 usbuuc)");
                                System.out.print("Dooro bundle: ");
                                int data_MIFI = input.nextInt();
                                double bundleCost = (data_MIFI == 5) ? 5 : (data_MIFI == 10) ? 10 : 0;
                                if (data_MIFI > 0 && data_MIFI <= haraagaagu) {
                                    haraagaagu -= data_MIFI;
                                    System.out.println("data_MIFI waa la shubay. Haraaga: $" + haraagaagu);
                                } else {
                                    System.out.println("Doorasho khaldan ama lacag kuma filna."+bundleCost);
                                }
                            } else if (subChoice == 4) {
                                int internetChoice;
                                do {
                                    System.out.println("\nfadlan dooro number");
                                    System.out.println("1. Isbuucle ");
                                    System.out.println("2. Time-based Packages");
                                    System.out.println("3. maalinle");
                                    System.out.println("4. bille");
                                    System.out.println("5. exit");
                                    System.out.println(" dooro mid");
                                     internetChoice = input.nextInt();
                                    switch (internetChoice) {
                                        case 1:
                                            System.out.print("geli Lacagta: ");
                                            double lacag3 = input.nextDouble();
                                            if (lacag3 <= haraagaagu) {
                                                System.out.print("Ma hubtaa inaad $" + lacag3 + " kushubtid " + "? (1=Haa, 2=Maya): ");
                                                int confirm = input.nextInt();
                                                if (confirm == 1) {
                                                    haraagaagu -= lacag3;
                                                    System.out.println("Waa lagu guuleystay. Haraaga: $" + haraagaagu);
                                                }
                                                break;
                                            }
                                        case 2: {
                                            System.out.print("lamberka : ");
                                            int number1 = input.nextInt();
                                            System.out.println("lcgta");
                                            double lacag1 = input.nextDouble();
                                            if (lacag1 <= haraagaagu) {
                                                System.out.print("Ma hubtaa inaad $" + lacag1 + " ugu shubto " + number1 + "? (1=Haa, 2=Maya): ");
                                                int confirm = input.nextInt();
                                                if (confirm == 1) {
                                                    haraagaagu -= lacag1;
                                                    System.out.println("Waa lagu guuleystay. Haraaga: $" + haraagaagu);
                                                    break;
                                                }
                                            }
                                        }
                                        case 3: {
                                            System.out.println("1. 100MB - $1.5");
                                            System.out.println("2. 250MB - $2.5");
                                            System.out.print("Dooro bundle (1-2): ");
                                            int dailyChoice = input.nextInt();
                                            double cost = 0;
                                            String bundle = "";
                                            switch (dailyChoice) {
                                                case 1:
                                                    cost = 1.5;
                                                    bundle = "100MB";
                                                    break;
                                                case 2:
                                                    cost = 2.5;
                                                    bundle = "250MB";
                                                    break;
                                                default:
                                                    System.out.println("Ikhtiyaar aan sax ahayn.");
                                                    break;
                                            }
                                            if (cost > 0 && cost <= haraagaagu) {
                                                haraagaagu -= cost;
                                                System.out.println("Waxaad iibsatay " + bundle + ". Haraaga: $" + haraagaagu);
                                            } else if (cost > 0) {
                                                System.out.println("Haraagaagu kuma filna.");
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("1. 5GB - $45.0");
                                            System.out.println("2. 10GB - $80.0");
                                            System.out.println("3. 20GB - $140.0");
                                            System.out.print("Dooro bundle (1-3): ");
                                            int monthChoice = input.nextInt();
                                            double cost = 0;
                                            String bundle = "";
                                            switch (monthChoice) {
                                                case 1:
                                                    cost = 45.0;
                                                    bundle = "5GB";
                                                    break;
                                                case 2:
                                                    cost = 80.0;
                                                    bundle = "10GB";
                                                    break;
                                                case 3:
                                                    cost = 140.0;
                                                    bundle = "20GB";
                                                    break;
                                                default:
                                                    System.out.println("Ikhtiyaar aan sax ahayn.");
                                                    break;
                                            }
                                            if (cost > 0 && cost <= haraagaagu) {
                                                haraagaagu -= cost;
                                                System.out.println("Waxaad iibsatay " + bundle + ". Haraaga: $" + haraagaagu);
                                            } else if (cost > 0) {
                                                System.out.println("Haraagaagu kuma filna.");
                                            }
                                            break;
                                        }
                                    }
                                } while (internetChoice != 5);
                            } else if (subChoice == 5) {
                                System.out.print("Fadlan geli lambarka qofka aad ugu shubeyso: ");
                                String number = input.next();
                                if (number.length() != 9) {
                                    System.out.println("Lambarku waa inuu noqda 9 digits.");
                                    continue;
                                }
                                if (!number.startsWith("61")) {
                                    System.out.println("Lambarku waa inuu bilaabmaa '61'.");
                                    continue;
                                }
                                if (number.equals("613396424")) {
                                    System.out.println("Lambarka aad dirayso iyo kanaga isku mid ma noqon karaan.");
                                    continue;
                                }
                                System.out.print("Fadlan geli qadarka lacagta : ");
                                double amount = input.nextDouble();
                                input.nextLine();
                                System.out.print("Fadlan geli PIN-kaaga si aad u xaqiijiso: ");
                                int enteredPin = input.nextInt();
                                if (enteredPin!= main_pin) {
                                    System.out.println("Waxaad si toos  ah ugu shubtay " + amount + "  lambar: " + number);

                                } else {
                                    int Number = input.nextInt();

                                    if (enteredPin== main_pin) {
                                        if (amount <= haraagaagu) {
                                            haraagaagu -= amount;
                                            System.out.println(" Lacagta $" + amount + " waxaa si toos ah loogu diray " + Number);
                                            System.out.println(" Haraagaaga cusub: $" + haraagaagu);
                                        } else {
                                            System.out.println("Haraagaagu kuma filna lacagta dirista.");
                                        }
                                    } else {
                                        System.out.println("PIN-ka waa khalad.");
                                    }
                                }
                            }
                        } while (subChoice != 6);

                        //waa bixi biil iyo inta uu ka koban yahy 1-3
                    } else if (choice == 3) {
                        int billChoice;
                        do {
                            System.out.println("\nBixi Biil:");
                            System.out.println("1. PaidPost ");
                            System.out.println("2. Ku iibso");
                            System.out.println("3. Ku exit");
                            System.out.print("Dooro mid: ");
                            billChoice = input.nextInt();
                            switch (billChoice) {


                                    case 1: {
                                        System.out.println("\nPost Paid:");
                                        System.out.println("1. Ogow biilka");
                                        System.out.println("2. Bixi biilka");
                                        System.out.println("3. Kabax bixi biil");
                                        System.out.print("Dooro mid: ");
                                       int Choicex = input.nextInt();
                                        switch (Choicex) {
                                            case 1:
                                                System.out.println("Biilkaagu waa: " + billAmount);
                                                break;
                                            case 2:
                                                if (haraagaagu >= billAmount) {
                                                    haraagaagu -= billAmount;
                                                    System.out.println("Biilkii waad bixisay. Haraaga cusub: $" + haraagaagu);
                                                } else {
                                                    System.out.println("Haraagaagu kuma filna.");
                                                }
                                                break;
                                            case 3:
                                                System.out.println("waad kabaxdey!");
                                                break;
                                        }

                                    }case 2: {
                                        System.out.print("Fadlan geli aqoonsigaaga: ");
                                        String id = input.nextLine();
                                        if (id.equals("123456"))
                                            System.out.println("Waad ku iibsatay si guul leh.");
                                        else
                                            System.out.println("Aqoonsi invalid ah.");
                                    }
                                    break;
                            }
                        } while (billChoice != 3);

                        //waa evcga saxda ah ee lcg wareejinta saxda waxana isticmaley arrey
                    } else if (choice == 4) {
                        input.nextLine();
                        while (true) {
                            System.out.print("Geli lambarka EVCPlus ee aad lacagta u dirayso: ");
                            String num = input.nextLine();
                            if (num.length() != 9) {
                                System.out.println("Lambarku waa inuu noqdaa 9 digit.");
                                continue;
                            }
                            if (!num.startsWith("61")) {
                                System.out.println("Lambarku waa inuu bilaabmaa '61'.");
                                continue;
                            }
                            if (num.equals("613396424")) {
                                System.out.println("Loodiraha iyo diraha isku mid ma noqon karaan.");
                                continue;
                            }
                            System.out.print("Geli PIN-kaaga: ");
                            int piN = input.nextInt();
                            if (piN != main_pin) {
                                System.out.println("PIN-ka waa khalad.");
                                input.nextLine();
                                continue;
                            }
                            System.out.print("Geli lacagta aad rabto in aad dirto: ");
                            double amount = input.nextDouble();

                            if (amount > haraagaagu) {
                                System.out.println("Haraagaagu kuguma filna. Waxaad haysataa: $" + haraagaagu);
                                input.nextLine();
                                continue;
                            }
                            haraagaagu -= amount;
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy,HH:mm:ss");
                            String formattedDate = now.format(formatter);
                            lastTransaction = "[-EVCPLUS-]  $" + amount + " ayaad u dirtay " + num +
                                    ", Tar: " + formattedDate + ", Haraagaaga cusub: $" + haraagaagu;
                            last3Actions.add(lastTransaction);
                            System.out.println(lastTransaction);
                            input.nextLine();
                            System.out.print("Ma dooneysaa inaad lacag kale dirto? (1=Haa, 2=Maya): ");
                            int again = input.nextInt();
                            input.nextLine();
                            if (again != 1) {
                                System.out.println("mahadsanid");
                                break;
                            }
                        }

                        //waa warbixin kooban iyo inta ay kakoban tahy 1-5
                    } else if (choice == 5) {
                        int dooro;
                        do {
                            System.out.println("\n====Warbixin kooban====:");
                            System.out.println("1. Last action");
                            System.out.println("2. Wareejintii ugu dambeysay");
                            System.out.println("3. Iibsashadii ugu dambeysay");
                            System.out.println("4. Last 3 action");
                            System.out.println("5. exit");
                            System.out.print("Dooro mid: ");
                            dooro = input.nextInt();
                            {
                                if (dooro == 1) {
                                    System.out.println("\n--- last Action---");
                                    System.out.println(lastTransaction);
                                } else if (dooro == 2) {
                                    System.out.println(lastTransaction);
                                } else if (dooro == 3) {
                                    System.out.println("\n--- 3da Ugu Dambeysay ee Lacag Dirista ---");
                                    if (last3Actions.isEmpty()) {
                                        System.out.println("Wax lacag ah lama dirin wali.");
                                    } else {
                                        int start = Math.max(last3Actions.size() - 3, 0);
                                        for (int i = start; i < last3Actions.size(); i++) {
                                            System.out.println(last3Actions.get(i));
                                        }
                                    }
                                }
                            }
                            System.out.println("Mahadsanid, waxaa lagaa baxay.");
                        } while (dooro != 5);
                        System.out.println("mahadsanid.");

                        //waa salama bank iyo inta ay kakoobantahay 1-5
                    } else if (choice == 6) {
                        int choice1;
                        do {
                            System.out.println("\n=== salama bank===");
                            System.out.println("1.itusi haraga");
                            System.out.println("2.lacag dhigasho");
                            System.out.println("3.lcg qadasho ");
                            System.out.println("4.kawareeji evc plus ");
                            System.out.println("5.exit ");
                            System.out.println("dooro mid:");
                            choice1 = input.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("Haraagaaga Salaama Bank waa: $" + salaamaBalance);
                                    break;
                                case 2:
                                    System.out.print("Fadlan geli lacagta aad dhigeyso: ");
                                    double dhigasho = input.nextDouble();
                                    if (dhigasho <= 0) {
                                        System.out.println("Lacag negative ah ama eber lama oggola.");
                                        continue;
                                    }
                                    salaamaBalance += dhigasho;
                                    System.out.println("Waad dhigatay $" + dhigasho + ". Haraaga cusub: $" + salaamaBalance);
                                    break;
                                case 3:
                                    System.out.print("Fadlan geli lacagta aad ka qaadaneyso: ");
                                    double qaadasho = input.nextDouble();
                                    if (qaadasho <= 0) {
                                        System.out.println("Lacag negative ah ama eber lama oggola.");
                                        continue;
                                    }
                                    if (qaadasho <= salaamaBalance) {
                                        salaamaBalance -= qaadasho;
                                        System.out.println("Waad qaaday $" + qaadasho + ". Haraaga cusub: $" + salaamaBalance);
                                    } else {
                                        System.out.println("Haraagaagu kuma filna.");
                                    }
                                    break;
                                case 4: {
                                    while (true) {
                                        System.out.print("Geli lambarka akoonka Salaama Bank ee qofka: ");
                                        input.nextLine();
                                        accountNumber = input.nextLine();
                                        if (accountNumber.length() != 10)
                                            continue;
                                         System.out.print("Geli qadarka lacagta aad wareejinayso: $");
                                         double amount = input.nextDouble();
                                         if (amount > salaamaBalance) {
                                            System.out.println("Lacag ku filan ma haysatid. Fadlan isku day mar kale.");
                                         } else {
                                            salaamaBalance -= amount;
                                            System.out.println("Lacag $" + amount + " ayaa si guul leh loogu wareejiyay akoonka " + accountNumber);
                                            System.out.println("Haraagaaga cusub: $" + salaamaBalance);
                                         }
                                        break;
                                    }
                                }
                                case 5:
                                    System.out.println("Waad ka baxday Salaama Bank.");
                                    break;
                            }
                        } while (choice1 != 5);

                        //waa marreynta  waxuuna usameysan yahy method ahan iyo inta ay kakobantahy 1-6
                    } else if (choice == 7) {
                        int choice2;
                        language = "English";
                        do {
                            System.out.println("\n==== Marreynta====");
                            System.out.println("1.bedel lambarka sirta ah");
                            System.out.println("2.bedel luqqada ");
                            System.out.println("3. wargalin  mobile lumay");
                            System.out.println("4.lacag xirasho");
                            System.out.println("5.uceli lacag qaldantay");
                            System.out.println("6.exit");
                            System.out.println("dooro mid:");
                            choice2 = input.nextInt();
                            switch (choice2) {
                                case 1:{
                                    System.out.print("Geli PIN-ka cusub: ");
                                    int newPin = input.nextInt();
                                    if (newPin == main_pin) {
                                        System.out.println("mahan inee isku mid noqdan pinki hore iyo kan cusub");
                                        continue;
                                    }
                                    System.out.println("hubi pinkaga cusub");
                                    int hubin = input.nextInt();
                                    System.out.println("PIN-ka waa la bedelay si guul leh.wuxuna noqdey"+hubin);
                                    break;
                                }
                                case 2:
                                    language = changeLanguage(input, language);
                                    break;
                                case 3:
                                    System.out.println("fadlan geli mobilka lumay :");
                                    int mobilka_lumay = input.nextInt();
                                    System.out.println("geli lamber siredkiisa");
                                    int pin2 = input.nextInt();
                                    if (pin2 == 1213)
                                        System.out.println(mobilka_lumay+"sida ugu dhaqsiyaha badan laguugu radinah locationkiisa macmiil mahadsanaid");
                                    else {
                                        System.out.println("lambersiredka waa qalad");
                                    }
                                    break;
                                case 4:
                                    System.out.println("soogali xirashada");
                                    System.out.println("gali lamberka qaladka ah :");
                                    int num = input.nextInt();
                                    System.out.println("geli lamberkii loowadey:");
                                    int num2 = input.nextInt();
                                    System.out.println("fadlan geli macluumaad ");
                                    int mac = input.nextInt();
                                    if (num != num2) {
                                        System.out.print("Ma hubtaa inaad xayirtid lcgtaan" + "? (1=Haa, 2=Maya): ");
                                        int confirm = input.nextInt();
                                        if (confirm == 1) {
                                            System.out.println("waala kaxiray lcgtaas"+mac);
                                        } else {
                                            System.out.println("Howsha waa la joojiyay.");
                                        }
                                        break;
                                    }
                                case 5:
                                    System.out.print("Geli lambarka aad si khalad ah ugu dirtay: ");
                                    String wrongNumber = input.next();
                                    System.out.print("Geli qadarka lacagta: ");
                                    double amount = input.nextDouble();
                                    System.out.println("Codsi dib u celin lacag ah ayaa la diiwaan geliyey: $" + amount + " oo loo diray " + wrongNumber);
                                    break;
                            }
                        } while (choice2 != 6);
                    }

                    //waa bill payment waana keybta udanbeysay waana 1-4
                    else if (choice == 8) {
                        int choice3;
                        do {
                            System.out.println("\n====bill payment===");
                            System.out.println("1.itusi haraga billka");
                            System.out.println("2.wada bixi billka");
                            System.out.println("3.qeyb kabixi biilka");
                            System.out.println("4.exit");
                            System.out.println("dooro mid:");
                            choice3 = input.nextInt();
                            switch (choice3) {
                                case 1: {
                                    if (billAmount > 0) {
                                        System.out.println("Biilka haray waa: $" + billAmount);
                                    } else {
                                        System.out.println("Biil ma jiro, dhammaan waa la bixiyay.");
                                    }
                                    break;
                                }
                                case 2: {
                                    if (!billPaid && billAmount > 0) {
                                        System.out.print("Fadlan geli lacagta: ");
                                        double lacag = input.nextDouble();
                                        if (lacag == billAmount) {
                                            billAmount = 0;
                                            billPaid = true;
                                            System.out.println("Biilkii waa la wada bixiyay.");
                                        } else {
                                            System.out.println("Lacagtu waa inee la ikaataa lcgta kugu jirta.");
                                        }
                                    } else {
                                        System.out.println("Biil waa labixiye.");
                                    }
                                    break;
                                }
                                case 3: {
                                    if (billAmount > 0) {
                                        System.out.print("Fadlan geli lacagta aad rabto inaad bixiso: ");
                                        double qaybLacag = input.nextDouble();
                                        if (qaybLacag <= billAmount && qaybLacag > 0) {
                                            billAmount -= qaybLacag;
                                            System.out.println("Waxaad bixisay $" + qaybLacag + ". Haraaga biilka: $" + billAmount);
                                        } else {
                                            System.out.println("Lacag khaldan. Fadlan geli lacag ka yar ama la eg haraaga.");
                                        }
                                    } else {
                                        System.out.println("lama aqbalayo wax kaweyn billAountigaga waxa kugu jiro.");
                                    }
                                    break;
                                }
                            }
                        } while (choice3 != 4);
                        System.out.println("Good bye");
                    }
                } while (choice != 9);
               System.out.println("waalaga baxay.");
            }else {
                System.out.println("waa qalad pinkaga");
            }
        }else {
                System.out.println("Code-ka waa khalad.");
            }
        }
    public static String changeLanguage(Scanner input, String currentLanguage) {
        System.out.println("Luqaddaada hadda waa: " + currentLanguage);
        System.out.println("1. Somali");
        System.out.println("2. English");
        System.out.print("Dooro luqad: ");
        int langChoice = input.nextInt();
        switch (langChoice) {
            case 1:
                currentLanguage = "Somali";
                System.out.println("Waad dooratay luqadda: " + currentLanguage);
                break;
            case 2:
                currentLanguage = "English";
                System.out.println("Waad dooratay luqadda: " + currentLanguage);
                break;
            default:
                System.out.println("Doorasho khaldan.");
                break;
        }

        return currentLanguage;
    }


}
