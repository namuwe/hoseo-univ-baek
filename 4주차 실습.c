
#include <stdio.h>
#define NUM 5

void menu(int* select);
void buyGoods(int buy[100]);
void sellGoods(int sell[100]);
void howManyGoods(int sell[100], int buy[100], char name[NUM][100]);
void addName(char name[NUM][100]);

int main()
{
	int buy[100] = { 0 };
	int sell[100] = { 0 };
	char* name[NUM][100] = { {"0"},{"0"}};
	int select = 0;
	int i = 0;

	do
	{
		menu(&select);

		switch (select)
		{
		case 1:
			buyGoods(buy);
			break;
		case 2:
			sellGoods(sell);
			break;
		case 3:
			howManyGoods(sell, buy, name);
			break;
		case 4:
			addName(name);
			break;
		case 5:
			break;
		}

	} while (select != 5);

	return 0;
}

//메뉴 출력
void menu(int* select)
{
	printf("[쇼핑몰 관리 프로그램]\n");
	printf("원하는 메뉴를 입력해 주세요.\n");
	printf("1.입고\n2.판매\n3.상품현황\n4.상품명 입력\n5.종료\n");
	scanf("%d", select);
}

//구매 입력
void buyGoods(int buy[100])
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

//판매 입력
void sellGoods(int sell[100])
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

//계산 및 출력
void howManyGoods(int sell[100], int buy[100], char name[NUM][100])
{
	int i = 0;
	int high = sell[0];
	int high_ID = 1;
	int low = sell[0];
	int low_ID = 1;
	int all_buy = 0;
	int all_sell = 0;

	for (i = 0; i < NUM; i++)	//가장 많이 팔린 물건 구하기
	{
		if (high < sell[i])
		{
			high = sell[i];
			high_ID = i + 1;
		}

		if (low > sell[i])		//가장 적게 팔린 물건 구하기
		{
			low = sell[i];
			low_ID = i + 1;
		}
	}

	for (i = 0; i < NUM; i++)	//총 구매량, 총 판매량 구하기
	{
		all_buy += buy[i];
		all_sell += sell[i];
	}

	//남은 수량 표시
	printf("상품의 남은 수량 :");
	for (int i = 0; i < NUM; i++)
		printf("%3d", buy[i] - sell[i]);
	printf("\n");

	//판매량, 판매율 표시
	printf("총 판매량 : %d (판매율 : %.2f)\n", all_sell, (float)all_sell / (float)all_buy * 100);		

	printf("가장 많이 팔린 상품 ID : %d, 상품명 : %s, %d개\n", high_ID, name[high_ID-1], high);
	printf("가장 적게 팔린 상품 ID : %d, 상품명 : %s, %d개\n", low_ID, name[low_ID-1], low);
	for (i = 0;i < NUM;i++)
		if (buy[i] - sell[i] <= 2)
			printf("ID %d, 상품명 : %s, 상품이 부족합니다. (남은 갯수 : %d)\n", i + 1,name[i], buy[i] - sell[i]);
}

//이름 입력
void addName(char name[NUM][100])
{
	int i = 0;
	for (i = 0;i < NUM;i++)
	{
		printf("ID %d의 상품명을 입력해주세요.\n", i + 1);
		scanf("%s", name[i]);
	}
}
