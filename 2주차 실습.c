#include <stdio.h>

int main ()
{
	int num = 0;
	int buy[100];
	int sell[100];
	int ID[100];
	int i;
	int all_buy = 0;
	int all_sell = 0;
	float sell_per = 0;
	int sell_high = 0;
	int sell_high_ID = 0;
	int sell_low_ID = 0;

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

	int sell_low = sell[0];

	for (i = 0;i < num;i++)
	{
		all_buy += buy[i];
		all_sell += sell[i];

		if (sell_high < sell[i])
		{
			sell_high = sell[i];
			sell_high_ID = i + 1;
		}

		if (sell_low > sell[i])
		{
			sell_low = sell[i];
			sell_low_ID = i + 1;
		}
	}

	printf("재고 수량 : ");
	for (i = 0;i < num;i++)
		printf("%2d", buy[i] - sell[i]);
	printf("\n");

	printf("총 판매량 : %d", all_sell);
	printf(" (판매율 : %.2f%%)\n", ((float)all_sell / (float)all_buy) * 100);
	printf("가장 많이 팔린 상품 ID : %d, %d개\n", sell_high_ID, sell_high);
	printf("가장 적게 팔린 상품 ID : %d, %d개\n", sell_low_ID, sell_low);

	for (i = 0;i < num;i++)
		if (buy[i] - sell[i] <= 2)
			printf("ID %d의 상품이 부족합니다. (남은 갯수 : %d)", i + 1, buy[i] - sell[i]);

	return 0;
}
