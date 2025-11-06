
#include <stdio.h>
#define NUM 5

typedef struct Goods {
	int ID;
	char name[100];
	int buy;
	int sell;
	int price;
}GOODS;

void menu(int *select);
void buyGoods(GOODS G[]);
void sellGoods(GOODS G[]);
void howManyOneGoods(GOODS G[]);
void howManyAllGoods(GOODS G[]);
int findID(GOODS G[]);

int main()
{
	int select = NULL;
	struct Goods G[5]={0};

	do
	{	
		menu(&select);

		switch (select)
		{
		case 1:
			buyGoods(G);
			break;
		case 2:	
			sellGoods(G);
			break;
		case 3:
			howManyOneGoods(G);
			break;
		case 4:
			howManyAllGoods(G);
			break;
		case 5:
			return 0;
		}

	} while (1);
}

//메뉴 출력
void menu(int *select)
{
	printf("[쇼핑몰 관리 프로그램]\n");
	printf("원하는 메뉴를 입력해 주세요.\n");
	printf("1.입고\n2.판매\n3.개별현황\n4.전체현황\n5.종료\n");
	scanf("%d", select);
}

//구매 입력
void buyGoods(GOODS G[])
{
	int select = NULL;
	int i_find_ID = findID(G);

	if (i_find_ID != -1) {
		printf("상품명을 입력해 주세요.\n");
		scanf("%s", (G + i_find_ID)->name);
		printf("상품 입고량을 입력해 주세요.\n");
		scanf("%d", &(G + i_find_ID)->buy);
		printf("상품 판매가격을 입력해 주세요.\n");
		scanf("%d", &(G + i_find_ID)->price);
	}
	else {
		printf("상품 ID를 찾을 수 없습니다. 새로 등록하시겠습니까?\n1.예\n2.아니요\n");
		scanf("%d", &select);
		if (select == 1) {
			for (int i = 0; i < 5;i++)
				if ((G + i)->ID == 0) {
					i_find_ID = i;
				}

			if (i_find_ID == -1) {
				printf("등록 가능한 상품수 상한에 도달했습니다.(최대 등록 가능한 상품수 : 5개)\n");
			}
			else {
				(G + i_find_ID)->ID = (i_find_ID + 1);
				printf("상품명을 입력해 주세요.\n");
				scanf("%s", (G + i_find_ID)->name);
				printf("상품 입고량을 입력해 주세요.\n");
				scanf("%d", &(G + i_find_ID)->buy);
				printf("상품 판매가격을 입력해 주세요.\n");
				scanf("%d", &(G + i_find_ID)->price);
			}
		}
	}
}

//판매 입력
void sellGoods(GOODS G[])
{
	int i_find_ID = findID(G);

	if (i_find_ID != -1) {
		printf("판매량을 입력해 주세요.\n");
		scanf("%d", &(G + i_find_ID)->sell);
	}
	else
		printf("해당 ID를 가진 상품을 찾을 수 없습니다.\n");
}

//개별 현황 출력
void howManyOneGoods(GOODS G[])
{
	int i_find_ID = findID(G);

	if (i_find_ID != -1) {
		printf("ID%3 : %3d\n", (G + i_find_ID)->ID);
		printf("이름%3 : %3s\n", (G + i_find_ID)->name);
		printf("입고량%3 : %3d\n", (G + i_find_ID)->buy);
		printf("판매량%3 ; %3d\n", (G + i_find_ID)->sell);
		printf("남은수량%3 ; %3d\n", ((G + i_find_ID)->buy) - ((G + i_find_ID)->sell));
		printf("판매가격%3 : %3d원\n", (G + i_find_ID)->price);
		printf("수익%3 : %3d원\n", ((G + i_find_ID)->price)*((G+i_find_ID)->sell));
	}
	else
		printf("해당 ID를 가진 상품을 찾을 수 없습니다.");
};

//전체현황 출력
void howManyAllGoods(GOODS G[])
{
	int high_ID = 0;
	int low_ID = 0;
	int all_buy = 0;
	int all_sell = 0;

	for (int i = 0; i < NUM; i++)	//가장 많이 팔린 물건 구하기
	{
		if ((G + high_ID)->sell < (G + i)->sell)	//가장 많이 팔린 물건 구하기
			high_ID = i;

		if ((G + low_ID)->sell > (G + i)->sell)		//가장 적게 팔린 물건 구하기
			low_ID = i;
	}

	for (int i = 0; i < NUM; i++)	//총 구매량, 총 판매량 구하기
	{
		all_buy += (G + i)->buy;
		all_sell += (G + i)->sell;
	}
	for (int i = 0;i < 5;i++)
	{
		printf("ID%3 : %3d\n", (G + i)->ID);
		printf("이름%3 : %3s\n", (G + i)->name);
		printf("입고량%3 : %3d\n", (G + i)->buy);
		printf("판매량%3 ; %3d\n", (G + i)->sell);
		printf("남은수량%3 ; %3d\n", ((G + i)->buy) - ((G + i)->sell));
		printf("판매가격%3 : %3d원\n", (G + i)->price);
		printf("수익%3 : %3d원\n", ((G + i)->price) * ((G + i)->sell));
		printf("\n");
	}

	//판매량, 판매율 표시
	printf("총 판매량 : %d (판매율 : %.2f)\n", all_sell, (float)all_sell / (float)all_buy * 100);
	printf("\n");

	printf("가장 많이 팔린 상품 ID : %d, 상품명 : %s, %d개\n", (G + high_ID)->ID, (G + high_ID)->name, (G + high_ID)->sell);
	printf("가장 적게 팔린 상품 ID : %d, 상품명 : %s, %d개\n", (G + low_ID)->ID, (G + low_ID)->name, (G + low_ID)->sell);
	printf("\n");
	for (int i = 0;i < NUM;i++)
		if ((G + i)->buy - (G + i)->sell <= 2)
			printf("ID %d, 상품명 : %s, 상품이 부족합니다. (남은 갯수 : %d)\n", (G + i)->ID, (G + i)->name, (G + i)->buy - (G + i)->sell);
}

//ID 찾기
int findID(GOODS G[])
{
	int ID = NULL;
	int select_ID = 0;
	printf("상품 ID를 입력해 주세요.\n");
	scanf("%d", &select_ID);
	for (int i = 0;i < 5;i++) {
		if (select_ID == (G + i)->ID) {
			ID = i;
			return ID;
		}
	}
	return -1;
}
