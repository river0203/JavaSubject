#include "GameModel.h"
#include "PlayView.h"
#include "CardController.h"
#include <iostream>

CardController::CardController(){
    
}

bool CardController::check_card_pair()
{
    GameModel game_modle;
    current_card = game_modle.get_select_card_value();
    
    //log
    for(int i = 0; i < 2; i++)
    {
        std::cout << current_card << std::endl;
    }
}