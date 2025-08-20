class PlayView
{
private:
    /* data */
public:
    PlayView(/* args */);
    ~PlayView();
};

class Card
{
    private:
        /*m_img_front
        m_img_back
        m_img_current_card*/
        bool change_card;

    public:
        void change_card_img(int card_position_value);
};