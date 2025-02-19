package TestScripts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.testng.annotations.Test;

@Test(groups="Smoke")
public class DuplicateElementsTest {
	
	public void identifyElement()
	{
		int[] arr= {1,2,3,4,5,5,4,6};
		int index=0;
		int [] Duplicate=new int[arr.length];
		HashSet<Integer> set= new HashSet<>();
		
		for(int i:arr)
		{
			if (!set.contains(i))
			{
				set.add(i);
			}
			
			else
			{
				Duplicate[index]=i;
				index++;
			}
			
		}
		System.out.println(Arrays.toString(Duplicate));
	}

}
