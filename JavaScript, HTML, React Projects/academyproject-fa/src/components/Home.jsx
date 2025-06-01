import {Component} from 'react'
import image from '../Computer_Programmer2.jpg'

console.log(image)

class Home extends Component {

	render(){
		return(
			<div className='codingPic'>
			<img src={image} alt="Coding stockimg"></img>
			</div>
		)
	}
} 
export default Home