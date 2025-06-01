import "../styles/RandomGenerator.css"
import {useState} from 'react'

const RandomNumber =(props) => {

    const [randomNumber, setRandomNumber] = useState()

    const generateRandomNumber =() =>{
        setRandomNumber(Math.floor(Math.random() * 100))
        console.log(randomNumber)
        props.prediction(randomNumber)
         
    }
    //the setState is a method so you would need to use () and cannot assign it
    
    //after the onclick function I call the generate number method 
    //This displays the state/ java code - this will display the numbers
    return(
        <div>
            <div className='button' onClick={event => generateRandomNumber()}>Generate Random Number</div> 
            <div className='randomNumber'>{randomNumber}</div>
        </div>
    )
}

export default RandomNumber