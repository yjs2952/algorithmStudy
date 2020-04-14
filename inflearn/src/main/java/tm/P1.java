package tm;

public class P1 {

    public static void main(String[] args) {

        int priceCount = 4000;

        // 가격정보 배열
        int[] priceArray = new int[priceCount];

        for (int priceArrayIdx = 1; priceArrayIdx < priceCount; priceArrayIdx++ ) {
            priceArray[priceArrayIdx-1] = priceArrayIdx * 1000;
        }

        System.out.println("가격의 배열인덱스 : " + getSearchPriceArrayIntex(priceArray, 690000));
    }

    public static int getSearchPriceArrayIntex(int[] priceArray, int searchPrice) {
        int mid;
        int left = 0;
        int right = priceArray.length - 1;

        while (right >= left) {
            mid = (right + left) / 2;

            if (searchPrice == priceArray[mid]) {
                return mid;
            }

            if (searchPrice < priceArray[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
