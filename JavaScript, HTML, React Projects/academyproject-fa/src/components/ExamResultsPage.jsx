import axios from 'axios'
import {useState, useEffect} from 'react'
import {useParams} from 'react-router-dom'
import ExamComponent from './ExamComponent'
import '../styles/ExamResultComponent.css'

const ExamResultsPage =()=>{

    const params = useParams()

    const [examResults, setExamResults] = useState([])
     const api= 'http://localhost:8088/api/v1/examResult/trainee/'+params.id

   

   const loadExamResult =() => {
         axios.get(api)
                     .then(response =>{
      			setExamResults(response.data)
      			})
                     .catch(error => console.log('unable to load Result'))
      }

      useEffect(() => {
         loadExamResult();
      },[])

      console.log(examResults)


      return (
         <div>
               <div>

            <h1>Exam Results:</h1>
            <div className='resultCards'>
            {
               examResults.map(examResult => 
                     <ExamComponent key={examResult.id} examResult={examResult}/>)
               
                     
            } 
            </div>

            </div>

         </div>
      )

}

export default ExamResultsPage