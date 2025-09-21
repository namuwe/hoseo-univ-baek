#include <stdio.h>
#define NUM 5

void sum(int sell[], int buy[], int* all_buy, int* all_sell);
void sell_low_high(int* low, int* low_ID, int* high, int* high_ID, int sell[]);

int main()
{
	int buy[100] = { 0 };
	int sell[100] = { 0 };
	int i = 0;
	int ID = 0;
	int select = 0;
	int select2 = 0;
	int all_buy = 0;
	int all_sell = 0;
	int sell_low = 0;
	int sell_high = 0;
	int sell_high_ID = 0;
	int sell_low_ID = 0;

	do
	{
		printf("[쇼핑몰 관리 프로그램]\n");
		printf("원하는 메뉴를 입력해 주세요.\n");
		printf("1.입고\n2.판매\n3.상품현황\n4.종료\n");
		scanf("%d", &select);

		switch (select)
		{
		case 1:
			printf("입고 수량 입력방식을 선택해 주세요.\n");
			printf("1.전체 입고 수량 입력\n2.개별 입고 수량 입력\n");
			scanf("%d", &select2);

			switch (select2)
			{
			case 1:
				printf("5개 상품의 입고 수량을 입력해 주세요.\n");
				for (i = 0;i < NUM;i++)
					scanf("%d", &buy[i]);
				break;
			case 2:
				printf("제품의 ID를 입력해 주세요.\n");
				scanf("%d", &ID);
				printf("제품의 입고 수량을 입력해 주세요.\n");
				scanf("%d", &buy[ID-1]);
				break;
			}
			break;
		case 2:
			printf("판매 수량 입력방식을 선택해 주세요.\n");
			printf("1.전체 판매 수량 입력\n2.개별 판매 수량 입력\n");
			scanf("%d", &select2);
			switch (select2)
			{
			case 1:
				printf("5개 상품의 판매 수량을 입력해 주세요.\n");
				for (i = 0;i < NUM;i++)
					scanf("%d", &sell[i]);
				break;
			case 2:
				printf("제품의 ID를 입력해 주세요.\n");
				scanf("%d", &ID);
				printf("제품의 판매 수량을 입력해 주세요.\n");
				scanf("%d", &sell[ID-1]);
				break;
			}
			break;

		case 3:
			sell_low_high(&sell_low, &sell_low_ID, &sell_high, &sell_high_ID, sell);
			sum(&sell, &buy, &all_buy, &all_sell);
			printf("상품의 남은 수량 :");
			for (i = 0;i < NUM;i++)
				printf("%3d", buy[i] - sell[i]);
			printf("\n총 판매 수량 : %d (판매율 : %.2f)\n", all_sell, (float)all_sell/(float)all_buy * 100);
			printf("가장 많이 팔린 상품 ID : %d, %d개\n", sell_high_ID, sell_high);
			printf("가장 적게 팔린 상품 ID : %d, %d개\n", sell_low_ID, sell_low);
			break;
		case 4:
			break;
		}

	} while (select != 4);

	return 0;
}

void sell_low_high(int* low, int* low_ID, int* high, int* high_ID, int sell[])
{
	int i = 0;
	*low = sell[0];
	*low_ID = 0;
	*high_ID = 0;
	*high = sell[0];
	for(i=0;i<NUM;i++)
	{
		if (*high < sell[i])
		{
			*high = sell[i];
			*high_ID = i + 1;
		}

		if (*low > sell[i])
		{
			*low = sell[i];
			*low_ID = i + 1;
		}
	}
}

void sum(int sell[], int buy[], int* all_buy, int* all_sell)
{
	int i = 0;
	*all_buy = 0;
	*all_sell = 0;
	for (i = 0; i < NUM;i++)
	{
		*all_buy += buy[i];
		*all_sell += sell[i];
	}
}
