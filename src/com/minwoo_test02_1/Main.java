package test2;

public class Main {
    public static void main(String[] args) {

        boolean onOff = true;

        Apple apple = new Apple();

        while (true) {
            apple.equipment();
            apple.uniqueFunction();

            switch (apple.choice()) {
                case 1:
                    if (onOff == false) {
                        System.out.println("[ 핸드폰 전원이 꺼진상태에서는 사용할수 없습니다. ]");
                        break;
                    }

                    apple.deviceInformation();
                    switch (apple.choice()) {

                        case 1:
                            apple.name();
                            apple.manufacturer();
                            apple.model();
                            apple.price();
                            break;

                        case 2:
                            apple.change();
                            switch (apple.choice()) {
                                case 1:
                                    System.out.println("[애플 아이폰이 선택되었습니다.]");
                                    break;
                                case 2:
                                    System.out.println("[삼성 갤럭시가 선택되었습니다.]");
                                    break;
                                case 3:
                                    System.out.println("[샤오미 핸드폰이 선택되었습니다.]");
                                    break;
                                default:
                                    System.out.println("1부터 3까지 하나만 입력해주세요.");
                                    break;
                            }
                            break;


                        default:
                            System.out.println("1부터 2까지 하나만 입력해주세요.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("[ 핸드폰 전원이 켜졌습니다. ]");
                    onOff = true;
                    break;
                case 3:
                    System.out.println("[ 핸드폰 전원이 꺼졌습니다. ]");
                    onOff = false;
                    break;
                case 4:
                    System.out.println("1) 검색");
                    if (apple.choice() == 1) {
                        apple.search();
                    } else {
                        System.out.println("1만 입력해 주세요.");
                    }
                    break;

                default:
                    System.out.println("1부터 4까지 하나만 입력해 주세요.");
                    break;
            }
        }

//        Samsung samsung = new Samsung();

    }
}
