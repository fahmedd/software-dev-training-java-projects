import { useState } from "react"
import RandomNumber from "./RandomNumber"

const GameComponent=(props)=>{

    const [previousNumber, setpreviousNumber]= useState(0)
    const [message, setmessage]= useState("")
    const [userprediction, setuserprediction]= useState("")

    const buttonClicked=(argument)=>{
        setuserprediction(argument)
        setmessage('You selected ' + argument)
    }

    const checkPrediction =(number)=>{
        if ((number > previousNumber)&& (userprediction === 'Higher')){
            setmessage('You guessed correctly')
        } else if ((number < previousNumber) && (userprediction === 'Lower')){
            setmessage('You guessed correctly')
        } else {
            setmessage('You guessed incorrectly')
        }
        setpreviousNumber(number)
    }



    return(
        <div>
            <RandomNumber  prediction={checkPrediction}/>
            <button onClick={argument => buttonClicked('Higher')}>Higher</button>
            <button onClick={argument => buttonClicked('Lower')}>Lower</button>
            <p>Guess if the next value is Higher or Lower</p>
            <div>{message}</div>
            
        </div>
    )
}

export default GameComponent