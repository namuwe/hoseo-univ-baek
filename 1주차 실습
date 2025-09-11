#include <stdio.h>

int main ()
{
	int num = 0;
	int buy[100];
	int sell[100];
	int ID[100];
	int i;
	int out_ID;
	
	printf("상품 갯수를 입력하세요.");
	scanf("%d", &num);


	for (i = 0;i < num;i++)
	{
		printf("상품의 입고 수량을 입력하세요.");
		scanf("%d", &buy[i]);
		
		printf("상품의 판매 수량을 입력하세요.");
		scanf("%d", &sell[i]);

		printf("상품의 ID를 입력하세요.");
		scanf("%d", &ID[i]);
	}
	
	printf("남은 재고를 알고싶은 물품의 ID를 입력해 주세요.");
	scanf("%d", &out_ID);

	printf("%3d\n", buy[out_ID-1] - sell[out_ID-1]);

	for (i = 0;i < num;i++)
		printf("%3d\t", buy[i] - sell[i]);

	return 0;
}
