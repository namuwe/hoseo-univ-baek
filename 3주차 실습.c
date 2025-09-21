#include <stdio.h>
#define NUM 5

void print(int* select);
void buyGoods(int* buy);
void sellGoods(int* sell);
void howManyGoods(int* sell, int* buy, int* low, int* low_ID, int* high, int* high_ID, int* all_buy, int* all_sell);

int main()
{
	int buy[100] = { 0 };
	int sell[100] = { 0 };
	int select = 0;
	int all_buy = 0;
	int all_sell = 0;
	int sell_low = 0;
	int sell_high = 0;
	int sell_high_ID = 0;
	int sell_low_ID = 0;

	do
	{
		print(&select);

		switch (select)
		{
		case 1:
			buyGoods(buy);
			break;
		case 2:
			sellGoods(sell);
			break;
		case 3:
			howManyGoods(sell, buy, &sell_low, &sell_low_ID, &sell_high, &sell_high_ID, &all_buy, &all_sell);

			printf("상품의 남은 수량 :");
			for (int i = 0; i < NUM; i++)
				printf("%3d", buy[i] - sell[i]);
			printf("\n");
			printf("총 판매 수량 : %d (판매율 : %.2f)\n", all_sell, (float)all_sell / (float)all_buy * 100);
			printf("가장 많이 팔린 상품 ID : %d, %d개\n", sell_high_ID, sell_high);
			printf("가장 적게 팔린 상품 ID : %d, %d개\n", sell_low_ID, sell_low);
			break;
		case 4:
			break;
		}

	} while (select != 4);

	return 0;
}

void print(int* select)
{
	printf("[쇼핑몰 관리 프로그램]\n");
	printf("원하는 메뉴를 입력해 주세요.\n");
	printf("1.입고\n2.판매\n3.상품현황\n4.종료\n");
	scanf("%d", select);
}

void buyGoods(int* buy)		//구매 입력
{
	int i = 0;
	int ID = 0;
	int select = 0;
	printf("입고 수량 입력방식을 선택해 주세요.\n");
	printf("1.전체 입고 수량 입력\n2.개별 입고 수량 입력\n");
	scanf("%d", &select);

	switch (select)
	{
	case 1:
		printf("5개 상품의 입고 수량을 입력해 주세요.\n");
		for (i = 0; i < NUM; i++)
			scanf("%d", &buy[i]);
		break;
	case 2:
		printf("제품의 ID를 입력해 주세요.\n");
		scanf("%d", &ID);
		printf("제품의 입고 수량을 입력해 주세요.\n");
		scanf("%d", &buy[ID - 1]);
		break;
	}
}

void sellGoods(int* sell)	//판매 입력
{
	int i = 0;
	int ID = 0;
	int select = 0;
	printf("판매 수량 입력방식을 선택해 주세요.\n");
	printf("1.전체 판매 수량 입력\n2.개별 판매 수량 입력\n");
	scanf("%d", &select);
	switch (select)
	{
	case 1:
		printf("5개 상품의 판매 수량을 입력해 주세요.\n");
		for (i = 0; i < NUM; i++)
			scanf("%d", &sell[i]);
		break;
	case 2:
		printf("제품의 ID를 입력해 주세요.\n");
		scanf("%d", &ID);
		printf("제품의 판매 수량을 입력해 주세요.\n");
		scanf("%d", &sell[ID - 1]);
		break;
	}
}

void howManyGoods(int* sell, int* buy, int* low, int* low_ID, int* high, int* high_ID, int* all_buy, int* all_sell)		//계산
{
	int i = 0;
	*low = sell[0];
	*low_ID = 1;
	*high = sell[0];
	*high_ID = 1;
	*all_buy = 0;
	*all_sell = 0;

	for (i = 0; i < NUM; i++)	//가장 많이 팔린 물건 구하기
	{
		if (*high < sell[i])
		{
			*high = sell[i];
			*high_ID = i + 1;
		}

		if (*low > sell[i])		//가장 적게 팔린 물건 구하기
		{
			*low = sell[i];
			*low_ID = i + 1;
		}
	}

	for (i = 0; i < NUM; i++)	//총 구매량, 총 판매량 구하기
	{
		*all_buy += buy[i];
		*all_sell += sell[i];
	}
}
