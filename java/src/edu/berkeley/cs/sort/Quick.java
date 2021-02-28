package edu.berkeley.cs.sort;

public class Quick<T extends Comparable<T>> extends Sort<T> {
  protected Insertion<T> insertion = new Insertion<>();

  /** Get the index of the pivot element given a range (low, high) */
  protected int getPivotIndex(T[] input, int low, int high) {
    // TODO: complete this function
    return low;
  }

  private int partition(T[] input, int low, int high) {
    int i = low;
    int j = high + 1;
    int p = getPivotIndex(input, low, high);

    while (true) {
      while (less(input[++i], input[low])) {
        if (i == high) {
          break;
        }
      }

      while (less(input[low], input[--j])) {
        if (j == low) {
          break;
        }
      }

      if (i >= j) {
        break;
      }

      swap(input, i, j);
    }

    swap(input, low, j);
    return j;
  }

  @Override
  public void sort(T[] input) {
    sort(input, 0, input.length - 1);
  }

  /** Sort the given range (low, high) of the input array using quicksort */
  private void sort(T[] input, int low, int high) {
    if (high <= low) {
      return;
    }

    int j = partition(input, low, high);
    sort(input, low, j - 1);
    sort(input, j + 1, high);
  }
}
