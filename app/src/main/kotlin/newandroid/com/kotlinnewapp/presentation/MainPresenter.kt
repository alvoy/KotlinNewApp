package newandroid.com.kotlinnewapp.presentation

import newandroid.com.kotlinnewapp.view.MainView

class MainPresenter(var mainView: MainView?) {

    fun onResume() {
        mainView?.setMainTitle("")

    }

    fun onDestroy() {
        mainView = null
    }

    fun setToolbarText(){
        mainView?.setToolbarText("Programa")
    }


}