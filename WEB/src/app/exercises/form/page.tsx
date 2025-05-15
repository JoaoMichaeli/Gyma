"use client";
import { createExercise } from "@/app/actions/exercises-actions";
import Navbar from "@/components/navbar";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import Link from "next/link";
import { useActionState } from "react";

const initialState = {
  values: {
    name: "",
    muscleGroup: "",
    repetitions: "",
    series: "",
    restSec: "",
  },
  errors: {
    name: "",
    muscleGroup: "",
    repetitions: "",
    series: "",
    restSec: "",
  },
};

export default function ExercicesFormPage() {
  const [state, formAction, pending] = useActionState(
    createExercise,
    initialState
  );
  return (
    <>
      <Navbar active="Treinos" />

      <main className="flex items-center justify-center">
        <div className="bg-slate-900 rounded-2xl p-5 m-6 max-w-md w-full">
          <h2 className="font-bold text-white text-lg">Cadastrar Exercício</h2>
          <form action={formAction} className="space-y-4 mt-6">
            <div>
              <Input name="name" placeholder="Nome do exercício" aria-invalid={!!state?.errors.name} defaultValue={state?.values.name} className="text-white" />
              <span className='text-sm text-destructive'>{state?.errors.name}</span>
            </div>

            <div className="relative">
              <select
                name="muscleGroup"
                defaultValue=""
                className="text-white bg-slate-800 w-full p-2 rounded appearance-none"
                aria-invalid={!!state?.errors.muscleGroup}
              >
                <option value="" disabled hidden>Selecione um grupo muscular</option>
                <option value="Peito">Peito</option>
                <option value="Triceps">Tríceps</option>
                <option value="Costas">Costas</option>
                <option value="Biceps">Bíceps</option>
                <option value="Ombro">Ombro</option>
                <option value="Abdomen">Abdômen</option>
                <option value="Perna">Perna</option>
                <option value="Panturrilha">Panturrilha</option>
              </select>
              <span className="text-sm text-destructive">{state?.errors.muscleGroup}</span>
            </div>

            <div>
              <Input name="repetitions" type="number" placeholder="Número de repetições" aria-invalid={!!state?.errors.repetitions} defaultValue={state?.values.repetitions} className="text-white" />
              <span className='text-sm text-destructive'>{state?.errors.repetitions}</span>
            </div>

            <div>
              <Input name="series" type="number" placeholder="Número de séries" aria-invalid={!!state?.errors.series} defaultValue={state?.values.series} className="text-white" />
              <span className='text-sm text-destructive'>{state?.errors.series}</span>
            </div>

            <div>
              <Input name="restSec" type="number" placeholder="Tempo de descanso (segundos)" aria-invalid={!!state?.errors.restSec} defaultValue={state?.values.restSec} className="text-white" />
              <span className='text-sm text-destructive'>{state?.errors.restSec}</span>
            </div>

            <div className="flex justify-around">
              <Button variant="outline" asChild>
                <Link href="/exercises">Cancelar</Link>
              </Button>
              <Button>Salvar</Button>
            </div>
          </form>
        </div>
      </main>
    </>
  );
}
