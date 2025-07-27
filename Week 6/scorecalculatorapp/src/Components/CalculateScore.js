import React from "react";
import "./mystyle.css"
const percenttodecimal=(Decimal)=>(Decimal.toFixed(2)+'%')
const Calscore=(total,goal)=>{
    return percenttodecimal(total/goal)
}
const CalculateScore=(props)=>(
    <div style={{alignContent:"center"}}>
        <h1>Student Details</h1>
        <div className="Name">
           <b><span>Name </span></b>
           <span>{props.Name}</span>

        </div>

        <div className="School">
        <b><span>School </span></b>
        <span>{props.School}</span>

        </div>
        <div className="Total">
        <b><span>Total </span></b>
        <span>{props.total}</span>

        </div>

        <div className="Goal">
        
        <b><span>Goal </span></b>
        <span>{props.goal}</span>

        </div>
        <div className="Score">
       <b><span>Score </span></b> 
        
        <span>
    
            {
                Calscore(props.total,props.goal)
            }
        </span>
        </div>

    </div>
)
export default CalculateScore;