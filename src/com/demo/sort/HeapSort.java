package com.demo.sort;

public class HeapSort {
	static void HeapAdjust(int[] a, int i, int size) // �����
	{
		int lchild = 2 * i + 1; // i�����ӽڵ����
		int rchild = 2 * i + 2; // i���Һ��ӽڵ����
		int max = i; // ��ʱ����
		if (i <= size / 2) // ���i����Ҷ�ڵ�Ͳ��ý��е���
		{
			if (lchild <= size && a[lchild] > a[max]) {
				max = lchild;
			}
			if (rchild <= size && a[rchild] > a[max]) {
				max = rchild;
			}
			if (max != i) {
				swap(a[i], a[max]);
				HeapAdjust(a, max, size); // �������֮����maxΪ���ڵ���������Ƕ�
			}
		}
	}

	static void BuildHeap(int[] a, int size) // ������
	{
		int i;
		for (i = size / 2; i >= 1; i--) // ��Ҷ�ڵ�������ֵΪsize/2
		{
			HeapAdjust(a, i, size);
		}
	}

	static void HeapSort(int[] a, int size) // ������
	{
		int i;
		BuildHeap(a, size);
		for (i = size - 1; i >= 0; i--) {
			// cout<<a[1]<<" ";
			swap(a[0], a[i]); // �����Ѷ������һ��Ԫ�أ���ÿ�ν�ʣ��Ԫ���е�����߷ŵ������
			// BuildHeap(a,i-1); //������Ԫ�����½���Ϊ�󶥶�
			HeapAdjust(a, 0, i - 1); // ���µ���Ѷ��ڵ��Ϊ�󶥶�
		}
	}

	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 0, 16, 20, 3, 11, 17, 8 };

		// int a[100];
		int size = a.length;
		HeapSort(a, size);
	}

}
