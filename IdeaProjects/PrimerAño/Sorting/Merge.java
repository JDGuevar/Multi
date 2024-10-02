public class Merge implements Algorithm
{
    public void sorting(int[] array)
    {
        mergesort(array, 0, array.length - 1);
    }

    void merge(int[] array, int left, int middle, int right)
    {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
/*
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];

        for (int j = 0; j < n2; j++)
            rightArray[j] = array[middle + 1 + j];
*/
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, middle + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2)
            if (leftArray[i] <= rightArray[j])
                array[k++] = leftArray[i++];
            else
                array[k++] = rightArray[j++];

        while (i < n1)
            array[k++] = leftArray[i++];

        while (j < n2)
            array[k++] = rightArray[j++];
    }

    void mergesort(int[] array, int left, int right)
    {
        if (left < right)
        {
            int middle = (left + right) / 2;

            mergesort(array, left, middle);
            mergesort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }
}
