package TestScripts;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.Test;

public class ReverseArrayTest {

	@Test(groups="Smoke")
	public void reverseArray()
	{
	
		int[] arr= {1,2,3,4,5};
		int start=0;
		int end=arr.length-1;
		while(start<end)
		{
			int temp= arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
		System.out.println(Arrays.toString(arr));
	}
	

	@Test
	public void removeandmerge()
	{
	
		int[] arr1= {1,2,3,4,5};
		int[] arr2= {3,4,6,7,8};
		int[] arr3= new int[arr1.length+arr2.length];
		int index=0;
		
		HashSet<Integer> set =new HashSet<>();
		
		for (int ele:arr1)
		{
			set.add(ele);
			arr3[index]=ele;
			index++;
			
		}
		for (int ele1:arr2)
		{
			if(!set.contains(ele1))
			{
				set.add(ele1);
				arr3[index]=ele1;
				index++;
			}
		}
		
		System.out.println(Arrays.toString(arr3));
		
	}
	
	@Test
	public void bubbleSort()
	{
		int[] arr={5, 2, 8, 3, 1};
		
		for (int j=0;j<arr.length;j++)
		{
		for (int i=0;i<arr.length-1;i++)
		{
			if (arr[i]>arr[i+1])
			{
				int temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
			}
		}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	@Test
	public void secondLargest()
	{
		int[] num= {1,5,6,7,8};
		
		int largest=Integer.MIN_VALUE;
		int seclargest=Integer.MIN_VALUE;
		
		for(int i=0;i<num.length;i++)
		{
			if (num[i]>largest)
			{
				seclargest=largest;
				largest=num[i];
				
			}
			else if (num[i]!=largest && num[i]>seclargest)
			{
				seclargest=num[i];
			}
		}
		System.out.println(seclargest);
	}
}
