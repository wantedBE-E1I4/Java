package com.ohgiraffers.collection.section01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.lang. *;

/**
 * arrayList 기초
 * - ArrayList는 순서가 있는 동적 리스트로, 데이터를 순차적으로 저장하며 중복을 허용한다.
 * - 배열과 달리 크기가 고정되지ㅣ 않아 필요에 따라 확장된다.
 * 배열은 크기 고정으로 유연성이 떨어지지만, ArrayList는 동적 관리가 가능하다.
 *
 * ArrayList의 주요 틍징
 * 1. 동적 크기 조정
 * - ArrayList는 내부적으로 배열을 사용하지만, (?) 크기가 고정되지 않아서 데이터가 추가될 때 자동으로 크기를 조정한다.
 * - 크기가 부족할 경우 새로운 배열을 생성하여 기존 데이터를 복사하고 새로운 데이터를 추가하는 방식으로 작업한다.
 *
 * 2. 중복허용
 * - ArrayList는 같은 값을 여러 번 저장할 수 있ㅇ다. 이는 데이ㅓㅌ 중복이 필요한 경우 유용하다.
 *
 * 3. 순서 유지
 * - 요소의 순서가 유지되므로, 인덱스를 통해 특정 요소에 접근할 수 있다.
 *
 * 4. 데이터 타입
 * - ArrayList는 제네릭을 사용하여 다양한 데이터 타입을 저장할 수 있다.
 *
 * 5. 성능
 * - 요소 추가 시, 리스트의 끝이 추가되는 경우 o(1)의 시간 복잡도를 가진다.
 * 그러나 중간에 요소를 삽입하거나 삭제하는 경우 0(n)의 시간 복잡도를 가지므로 주의가 필요하다.
 * 0:a, 1:b, 2:c, 3:d의 경우 1번 인덱스를 제거하면 0:a, 1:c, 2:d가 되어야 한다.
 * 즉 모든 요소만큼 인덱스가 변경되어야 하기 때문에 시간 복잡도가 요소의 갯수만큼 증가한다.
 *
 * 6. 메모리 사용
 * Array List는 내부 배열을 사용하기 때문에, 데이터의 수가 많아질 경우 메모리 사용량이 증가할 수 있다.
 * - 메모리 부족 상황에서 자동으로 배열을 재할당하기 때문에 성능 저하가 발생할 수 있다.
 *
 */
public class Application {
    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
                //List에 String을 참조한다.
        // bookList는 list 기능까지만 갖는다.
        bookList.add("자바의 정석"); //지정된 요소를 목록 끝에 추가한다.
        bookList.add("클린 코드");
        bookList.add("자바의 정석"); //bookList 길이 3 (중복 허용)

        System.out.println("ArrayList : " + bookList);
        String firstBook = bookList.get(0); //위치에 존재하는 요소 반환
        System.out.println("firstBook : " + firstBook);

        // 요소 삭제
        bookList.remove(0);
        System.out.println("ArrayList : " + bookList);

        // 요소 수정
        bookList.set(0, "Effective java");
        System.out.println("수정된 list : " + bookList);

        System.out.println("ArrayList : " + bookList.size()); //for문에 사용

        String[] arrayBooks = new String[2];
        arrayBooks[0] = "Effective java";
        arrayBooks[1] = "클린 코드";
        //arrayBooks[2] = "추가 불가"; //error ArrayIndexOutOfBound...
        //arrayBooks = new String[3]; //그냥 배열을 새로 만드는거임..
        System.out.println("ArrayList : " + arrayBooks); //참조값
        //for (String book: arrayBooks) {} 대신 Arrays.toString 베열 값 출력
        System.out.println("Array :  " + Arrays.toString(arrayBooks));

        bookList.add("A");
        System.out.println("ArrayList : " + bookList);
        Collections.sort(bookList); //반환 타입 없는데 어떻게 변화가 됐지? 메서드는 매개변수를 받는데 객체타입 a=는 heap영역의 주소값을 갖는다.
        System.out.println("ArrayList : " + bookList); // heap에 x001에 정렬이 일어나면서 원본에 영향을 준다. //일반 값은 원본에 영향 X
        //list는 모든 타입을 받을 수 있음 // 유연하게 저장할 수 있음
    }
}
