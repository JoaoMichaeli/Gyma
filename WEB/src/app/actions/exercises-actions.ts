import { redirect } from "next/navigation";
const API_URL = "http://localhost:8080/exercises";

export async function getExercises(){
  const response = await fetch(API_URL)
  return await response.json()
}

export async function createExercise(initialState: any, formData: FormData) {
  const muscleGroup = formData.get("muscleGroup")?.toString() || "";

  const data = {
    name: formData.get("name"),
    muscleGroup: muscleGroup ? [muscleGroup] : [],
    repetitions: Number(formData.get("repetitions")) || 0,
    series: Number(formData.get("series")) || 0,
    restSec: Number(formData.get("restSec")) || 0,
  };

  const options = {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  };

  const response = await fetch(API_URL, options);

  if (!response.ok) {
    const errors = await response.json();
    const parsedErrors = Array.isArray(errors) ? errors : [];

    return {
      values: {
        name: typeof data.name === "string" ? data.name : "",
        muscleGroup: muscleGroup,
        repetitions: typeof data.repetitions === "number" ? data.repetitions : "",
        series: typeof data.series === "number" ? data.series : "",
        restSec: typeof data.restSec === "number" ? data.restSec : "",
      },
      errors: {
        name: parsedErrors.find((error: any) => error.field === "name")?.message,
        muscleGroup: parsedErrors.find((error: any) => error.field === "muscleGroup")?.message,
        repetitions: parsedErrors.find((error: any) => error.field === "repetitions")?.message,
        series: parsedErrors.find((error: any) => error.field === "series")?.message,
        restSec: parsedErrors.find((error: any) => error.field === "restSec")?.message,
      },
    };
  }

  redirect("/exercises");
}
