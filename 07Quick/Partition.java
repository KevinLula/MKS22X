import java.util.Random;
public class Partition{
	public static int part(int[] data, int start, int end){
	int pivot = new Random.nextInt(end - start) + start;
	int temp = data[start];
	data[start] = data[pivot];
	data[pivot] = temp;
	int lt = start;
	int i = start + 1;
	int gt = end - 1;
	while(i <= gt){
	if(data[i] == pivot){
	i++;
	}
	if(data[i] < pivot){
	temp2 = data[i];
	data[i] = data[lt];
	data[lt] = temp2;
	lt++;
	i++;
	}
	if(data[i] > pivot){
	
	

	
