package com.ohgiraffers.d_arrays;

public class Application01 {
    public static void main(String[] args) {
        /**
         * 배열
         * 배열은 동일한 데이터 요소를 연속적으로 저장하는 자료구조입니다.
         * 선언 : 타입[] 변수명 = new 타입[n] (n은 크기를 의미하며 숫자가 들어감)
         * 인덱스(0부터 시작)을 사용해 요소에 접근한다.
         * 배열은 고정된 크기를 가지며, 생성 후 크기 변경이 불가능하다.
         * 배열의 길이는 "length" 속성을 이용해 크기를 확인할 수 있다.
         *
         * 예시:
         * int[] numbers = {1, 2, 3, 4, 5}
         *
         **/

        //배열 선언
        int[] numbers;


        /**
        /* 배열 복사 (깊은 복사)
         * 깊은 복사는 원본 배열의 요소를 새로운 배열에 복사하여,
         * 두 배열이 서로 독립적으로 존재하도록 만든다.
         * 원본 배열의 데이터는 변경되지 않으며, 깊은 복사된 배열에 대한 변경은
         * 원본 배열에 영향을 미치지 않는다.
         */
        int[] arr = new int[5];
        //int[] deepCopy  = java.util.Arrays.copyOf(arr, 5);
        int[] deepCopy = new int[5]; //= java.util.Arrays.copyOf(arr, 5);
        deepCopy[0] = arr[0];
        deepCopy[1] = arr[1];
        deepCopy[2] = arr[2];
        deepCopy[3] = arr[3];
        deepCopy[4] = arr[4];

        //복사되는 대상은 변경되지 않는다. 왜?
        //본떠서 만든거니까. 뎁스가 커져도 그대로 복사일뿐임

        deepCopy[1] = 10;
        System.out.println("원본 배열: " + java.util.Arrays.toString(arr));
        System.out.println("깊은 복사 배열: " + java.util.Arrays.toString(deepCopy));
        System.out.println("깊은 복사 배열의 주소 : " + deepCopy);
        System.out.println();
        /* 배열 복사 (얕은 복사)
         * 얕은 복사는 원본 배열의 참조를 새로운 변수에 할당한다.
         * 이 경우, 두 변수는 같은 배열을 가리키며,
         * 한 배열에서 데이터를 변경하면 다른 배열에도 영향을 미친다.
         */
        int[] shallowCopy = arr;
        shallowCopy[1] = 10;
        System.out.println("원본 배열: " + java.util.Arrays.toString(arr));
        System.out.println("얕은 복사 배열: " + java.util.Arrays.toString(shallowCopy));
        System.out.println("앝은 복사 배열의 주소 : " + shallowCopy);

    }
}
