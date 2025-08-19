class GameModel
{
private:
    int m_ary_stage1_card_arrangement[9] = {0};
    int m_select_card_value[2] = {0};
public:
    GameModel(/* args */);
    const int* get_ary_stage1_card_arrangement() const;
    const int* get_select_card_value() const;
    void set_select_card_value(int index, int value); /*클릭하는 카드를 갱신, 2개씩 짝을 짓도록*/
};

